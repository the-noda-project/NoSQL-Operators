package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators.ZRangeInfo;
import io.redisearch.AggregationResult;
import io.redisearch.Query;
import io.redisearch.SearchResult;
import io.redisearch.aggregation.AggregationBuilder;
import io.redisearch.aggregation.Group;
import io.redisearch.aggregation.SortedField;
import io.redisearch.aggregation.reducers.Reducer;
import io.redisearch.client.Client;
import io.redisearch.querybuilder.Node;
import io.redisearch.querybuilder.QueryBuilder;
import io.redisearch.querybuilder.QueryNode;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RediSearchQueryHelper {
    private final Pool<Jedis> jedisPool;
    private final Client client;
    private AggregationBuilder aggregationBuilder;
    private Query query;
    private ZRangeInfo zRangeInfo;
    private boolean isAggregate;
    private final QueryNode queryBuilder;
    private final ArrayDeque<Group> groups;

    public RediSearchQueryHelper(String indexName, Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.isAggregate = false;
        this.client = new Client(indexName, jedisPool);
        this.queryBuilder = QueryBuilder.intersect();
        this.groups = new ArrayDeque<>();
    }

    private void enableAggregate() {
        if(!isAggregate)
            isAggregate = true;
    }

    private String provideQuery() {
        if (StringPool.BLANK.equalsIgnoreCase(queryBuilder.toString()))
            return StringPool.STAR;
        else return queryBuilder.toString();
    }

    private AggregationBuilder getAggregationBuilder() {
        if(aggregationBuilder == null) {
            aggregationBuilder = new AggregationBuilder(provideQuery());
        }
        pendingAggregates();
        return aggregationBuilder;
    }

    private void pendingAggregates() {
        groups.forEach(group -> aggregationBuilder.groupBy(group));
        groups.clear();
    }

    private Query getQuery() {
        if(query == null) {
            query = new Query(provideQuery());
        }
        return query;
    }

    public Jedis getJedisResource() {
        return jedisPool.getResource();
    }

    public void setzRangeInfo(ZRangeInfo zRangeInfo) {
        this.zRangeInfo = zRangeInfo;
    }

    public boolean isAggregate() {
        return isAggregate;
    }

    public void printResults() {
        Optional.ofNullable(zRangeInfo).map(zRangeInfo1 -> {
            Map<String, Set<String>> rectangleSearchMember = zRangeInfo1.getKeys().stream()
                    .collect(Collectors.toMap(o -> o, o -> jedisPool.getResource().zrangeByScore(o, zRangeInfo1.getLowerBoundScore(), zRangeInfo1.getUpperBoundScore())));
            List<GeoCoordinate> geopos = rectangleSearchMember.entrySet().stream()
                    .map(key -> jedisPool.getResource().geopos(key.getKey(), key.getValue().toArray(StringPool.EMPTY_ARRAY)))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
            geopos.forEach(pos -> System.out.println(pos.toString()));
            return null;
        }).orElseGet(() -> {
            PRINTER.findByValue(isAggregate).print(client, isAggregate ? getAggregationBuilder() : getQuery());
            return null;
        });
    }

    public void applyGroupBy(String fieldName, String... fieldNames) {
        enableAggregate();
        String[] fieldNamess = Stream.concat(Stream.of(fieldName), Arrays.stream(fieldNames)).toArray(String[]::new);
        Group group = fieldNamess.length != 0 ? new Group(fieldNamess) : new Group();
        groups.add(group);
    }

    public void applyAggregate(Reducer reducer, Reducer... reducers) {
        enableAggregate();
        Group group = Optional.ofNullable(groups.peekLast())
                .orElseGet(() -> {
                    Group newGroup = new Group();
                    groups.add(newGroup);
                    return newGroup;
                });
        Stream.concat(Stream.of(reducer), Arrays.stream(reducers)).forEach(group::reduce);
    }

    public void applySortBy(SortedField... sortedFields) {
        if (!isAggregate) {
            if (sortedFields.length == 1)
                getQuery().setSortBy(sortedFields[0].getField(), sortedFields[0].getOrder().equals(SortedField.SortOrder.ASC.toString()));
            else
                throw new IllegalArgumentException("Only one SortOperator supported with no aggregations.");
        } else {
            getAggregationBuilder().sortBy(sortedFields);
        }
    }

    public int totalResults() {
        return (int) (isAggregate
                ? client.aggregate(getAggregationBuilder()).totalResults
                : client.search(getQuery()).totalResults);
    }

    public void applyReturnFields(String... fields) {
        getAggregationBuilder().load(fields);
        getQuery().returnFields(fields);
    }

    public void applyResultLimit(int limit) {
        getAggregationBuilder().limit(0, limit);
        getQuery().limit(0, limit);
    }

    public void applyPreQuery(Node node) {
        queryBuilder.add(node);
    }

    public void applyPostQuery(String s) {
        getAggregationBuilder().filter(s);
    }

    public AggregationResult executeAggregation() {
        return client.aggregate(getAggregationBuilder());
    }

    private enum PRINTER {
        AGGREGATE(true) {
            @Override
            public void print(Client client, Object o) {
                AggregationResult aggregate = client.aggregate((AggregationBuilder) o);
                List<Map<String, Object>> results = aggregate.getResults();
                int index = 0;
                for (Map<String, Object> t : results) {
                    int finalIndex = index;
                    t.keySet().forEach(k -> System.out.println(k + StringPool.COLON + aggregate.getRow(finalIndex).getString(k)));
                    index++;
                }
                System.out.println(aggregate.getResults());
            }
        },
        SEARCH(false) {
            @Override
            public void print(Client client, Object o) {
                SearchResult search = client.search((Query) o);
                System.out.println(search.docs);
            }
        };
        private final boolean isAggregate;

        PRINTER(boolean isAggregate) {
            this.isAggregate = isAggregate;
        }

        public abstract void print(Client client, Object o);

        public static PRINTER findByValue(final boolean val){
            return Arrays.stream(values()).filter(value -> value.isAggregate == val).findFirst().orElse(null);
        }
    }
}
