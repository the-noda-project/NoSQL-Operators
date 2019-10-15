package gr.unipi.noda.api.core.constants;

/**
 * @author adimo on 4/10/2019
 */
public enum Keywords {
    SUM("sum_"),
    MIN("min_"),
    MAX("max_"),
    AVG("avg_"),
    COUNT("count");

    private final String name;

    Keywords(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return name;
    }
}
