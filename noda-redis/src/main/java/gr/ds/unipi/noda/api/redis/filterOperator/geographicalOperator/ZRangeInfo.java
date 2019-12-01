package gr.ds.unipi.noda.api.redis.filterOperator.geographicalOperator;

public class ZRangeInfo {
    private final String key;
    private final Double lowerBoundScore;
    private final Double upperBoundScore;

    private ZRangeInfo(String key, Double lowerBoundScore, Double upperBoundScore) {
        this.key = key;
        this.lowerBoundScore = lowerBoundScore;
        this.upperBoundScore = upperBoundScore;
    }

    static ZRangeInfo of(String key, Double lowerBoundScore, Double upperBoundScore) {
        return new ZRangeInfo(key, lowerBoundScore, upperBoundScore);
    }

    public String getKey() {
        return key;
    }

    public Double getLowerBoundScore() {
        return lowerBoundScore;
    }

    public Double getUpperBoundScore() {
        return upperBoundScore;
    }
}
