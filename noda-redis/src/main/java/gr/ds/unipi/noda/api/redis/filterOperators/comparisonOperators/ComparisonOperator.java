package gr.ds.unipi.noda.api.redis.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.redis.filterOperators.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperators.Triplet;

import java.util.*;

public abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<List<Triplet> , U> {

    private final String randomString;

    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
        randomString = RandomStringGenerator.randomCharacterNumericString();
    }

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList();
        list.add(Triplet.newTriplet(getEvalExpression(), new String[]{randomString, getFieldName()}, new String[]{}));
        return list;
    }

    protected String getEvalExpression(){

        return  "local t = redis.call('ZRANGEBYSCORE', KEYS[2], '" + minumumRangeValue() + "', '"+maximumRangeValue() + "')\n" +
                        "local i = 1\n"+
                        "local temp = {}\n"+
                        "while(i <= #t) do\n"+
                        "    table.insert(temp, t[i+1])\n"+
                        "    table.insert(temp, t[i])\n"+
                        "    if #temp >= 1000 then\n"+
                        "        redis.call('SADD', KEYS[1], unpack(temp))\n"+
                        "        temp = {}\n"+
                        "    end\n"+
                        "    i = i+2\n"+
                        "end\n"+
                        "if #temp > 0 then\n"+
                        "    redis.call('SADD', KEYS[1], unpack(temp))\n"+
                        "end\n"+
                        "redis.call('EXPIRE' , KEYS[1], 100)\n"+
                        "return 1";
    }

    protected String minumumRangeValue(){
        return "-inf";
    }

    protected String maximumRangeValue(){
        return "+inf";
    }

    public StringBuilder toString(String level){
        StringBuilder sb = new StringBuilder();
        sb.append("-"+level+getClass()+ "field: "+ getFieldName() +" - value: "+getFieldValue()+"\n");
        return sb;
    }

    protected String getRandomString() {
        return randomString;
    }
}
