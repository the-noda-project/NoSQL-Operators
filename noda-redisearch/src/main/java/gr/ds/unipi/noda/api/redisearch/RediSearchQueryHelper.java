package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import gr.ds.unipi.noda.api.redisearch.filterOperators.geographicalOperators.geoSpatialOperators.ZRangeInfo;
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

class RediSearchQueryHelper {
    private final Pool<Jedis> jedisPool;
    private final Client client;
    private AggregationBuilder aggregationBuilder;
    private Query query;
    private ZRangeInfo zRangeInfo;
    private boolean isAggregate;
    private QueryNode queryBuilder;

    public RediSearchQueryHelper(String indexName, Pool<Jedis> jedisPool) {
        this.jedisPool = jedisPool;
        this.isAggregate = false;
        this.client = new Client(indexName, jedisPool);
        this.queryBuilder = QueryBuilder.intersect();
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
        return aggregationBuilder;
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
        if (Objects.nonNull(zRangeInfo)) {
            Map<String, Set<String>> rectangleSearchMember = zRangeInfo.getKeys().stream()
                    .collect(Collectors.toMap(o -> o, o -> jedisPool.getResource().zrangeByScore(o, zRangeInfo.getLowerBoundScore(), zRangeInfo.getUpperBoundScore())));
            List<GeoCoordinate> geopos = rectangleSearchMember.entrySet().stream()
                    .map(key -> jedisPool.getResource().geopos(key.getKey(), key.getValue().toArray(StringPool.EMPTY_ARRAY)))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
            geopos.forEach(pos -> System.out.println(pos.toString()));
        } else if (isAggregate) {
            AggregationResult aggregate = client.aggregate(getAggregationBuilder());
            List<Map<String, Object>> results = aggregate.getResults();
            int index = 0;
            for (Map<String, Object> t : results) {
                int finalIndex = index;
                t.keySet().forEach(k -> System.out.println(k + StringPool.COLON + aggregate.getRow(finalIndex).getString(k)));
                index++;
            }
            System.out.println(aggregate.getResults());
        } else {
            SearchResult search = client.search(getQuery());
            System.out.println(search.docs);
        }
    }

    public void applyGroupBy(String fieldName, Reducer... reducers) {
        enableAggregate();
        Group group = fieldName != null ? new Group(fieldName) : new Group();
        Arrays.stream(reducers).forEach(group::reduce);
        getAggregationBuilder().groupBy(group);
    }

    public void applyGroupBy(Reducer... reducers) {
        this.applyGroupBy(null, reducers);
    }

    public void applySortBy(SortedField... sortedFields) {
        if (isAggregate) {
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
}
