package gr.ds.unipi.noda.api.redisearch.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.constants.StringPool;
import io.redisearch.querybuilder.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Deprecated
final class RangeValue extends Value {
    private static final String POSITIVE_INFINITY = "+inf";
    private static final String NEGATIVE_INFINITY = "-inf";
    private final double from;
    private final double to;
    private boolean inclusiveMin = true;
    private boolean inclusiveMax = true;

    public boolean isCombinable() {
        return false;
    }

    private static void appendNum(StringBuilder sb, double n, boolean inclusive) {
        if (!inclusive) {
            sb.append(StringPool.OPEN_PARENTHESIS);
        }
        if (n == Double.NEGATIVE_INFINITY) {
            sb.append(NEGATIVE_INFINITY);
        } else if (n == Double.POSITIVE_INFINITY) {
            sb.append(POSITIVE_INFINITY);
        } else {
            sb.append(new BigDecimal(n).setScale(6, RoundingMode.HALF_EVEN).toPlainString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringPool.OPEN_BRACKET);
        appendNum(sb, this.from, this.inclusiveMin);
        sb.append(StringPool.SPACE);
        appendNum(sb, this.to, this.inclusiveMax);
        sb.append(StringPool.CLOSE_BRACKET);
        return sb.toString();
    }

    public RangeValue(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public RangeValue inclusiveMin(boolean val) {
        this.inclusiveMin = val;
        return this;
    }

    public RangeValue inclusiveMax(boolean val) {
        this.inclusiveMax = val;
        return this;
    }
}
