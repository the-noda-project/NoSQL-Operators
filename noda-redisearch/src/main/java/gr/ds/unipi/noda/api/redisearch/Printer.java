package gr.ds.unipi.noda.api.redisearch;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.AggregationResult;
import io.redisearch.Query;
import io.redisearch.SearchResult;
import io.redisearch.aggregation.AggregationBuilder;
import io.redisearch.client.Client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

enum Printer {
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

    Printer(boolean isAggregate) {
        this.isAggregate = isAggregate;
    }

    public abstract void print(Client client, Object o);

    public static Printer findByValue(final boolean val){
        return Arrays.stream(values()).filter(value -> value.isAggregate == val).findFirst().orElse(null);
    }
}
