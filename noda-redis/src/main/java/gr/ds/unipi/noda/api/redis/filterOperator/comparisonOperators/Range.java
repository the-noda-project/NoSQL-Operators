package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;

import java.util.*;

public class Range implements FilterOperator<List<Triplet>> {

    private final ComparisonOperator comparisonOperator1;
    private final ComparisonOperator comparisonOperator2;

    private Range(ComparisonOperator comparisonOperator1, ComparisonOperator comparisonOperator2){
        this.comparisonOperator1 = comparisonOperator1;
        this.comparisonOperator2 = comparisonOperator2;

    }

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList();
        list.add(Triplet.newTriplet(getEvalExpression(), new String[]{comparisonOperator1.getFieldName(), comparisonOperator1.getRandomString()}, new String[]{}));
        return list;
    }

    protected String getEvalExpression(){

        return  "local t = redis.call('ZRANGEBYSCORE', KEYS[1], '" + comparisonOperator1.minumumRangeValue() + "', '"+comparisonOperator2.maximumRangeValue() + "')\n" +
                "local i = 1\n"+
                "local temp = {}\n"+
                "while(i <= #t) do\n"+
                "    table.insert(temp, t[i+1])\n"+
                "    table.insert(temp, t[i])\n"+
                "    if #temp >= 1000 then\n"+
                "        redis.call('SADD', KEYS[2], unpack(temp))\n"+
                "        temp = {}\n"+
                "    end\n"+
                "    i = i+2\n"+
                "end\n"+
                "if #temp > 0 then\n"+
                "    redis.call('SADD', KEYS[2], unpack(temp))\n"+
                "end\n"+
                "redis.call('EXPIRE' , KEYS[2], 100)\n"+
                "return 1";
    }

    public static Range newRange(ComparisonOperator comparisonOperator1, ComparisonOperator comparisonOperator2){
        return new Range(comparisonOperator1, comparisonOperator2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return Objects.equals(comparisonOperator1, range.comparisonOperator1) &&
                Objects.equals(comparisonOperator2, range.comparisonOperator2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comparisonOperator1, comparisonOperator2);
    }

    public StringBuilder toString(String level){
        StringBuilder sb = new StringBuilder();
        sb.append("-"+level+getClass()+"\n 1: "+ comparisonOperator1.toString(level) +" 2: "+ comparisonOperator2.toString(level));
        return sb;
    }
}
