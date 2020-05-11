package gr.ds.unipi.noda.api.redisearch.filterOperators.geoperators.geographicalOperators;

import java.util.Set;

public final class ZRangeInfo {
    private final Set<String> keys;
    private final Double lowerBoundScore;
    private final Double upperBoundScore;

    private ZRangeInfo(Set<String> keys, Double lowerBoundScore, Double upperBoundScore) {
        this.keys = keys;
        this.lowerBoundScore = lowerBoundScore;
        this.upperBoundScore = upperBoundScore;
    }

    static ZRangeInfo of(Set<String> keys, Double lowerBoundScore, Double upperBoundScore) {
        return new ZRangeInfo(keys, lowerBoundScore, upperBoundScore);
    }

    public Set<String> getKeys() {
        return keys;
    }

    public Double getLowerBoundScore() {
        return lowerBoundScore;
    }

    public Double getUpperBoundScore() {
        return upperBoundScore;
    }
}
