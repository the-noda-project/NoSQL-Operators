package gr.ds.unipi.noda.api.core.constants;

/**
 * @author adimo on 4/10/2019
 */
public enum AggregationKeywords {
    SUM("sum_"),
    MIN("min_"),
    MAX("max_"),
    AVG("avg_"),
    COUNT("count");

    private final String name;

    AggregationKeywords(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
