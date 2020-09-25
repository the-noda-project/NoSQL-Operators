package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.Operator;
import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;

import java.util.*;

public abstract class ComparisonOperator<U> extends gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator<List<Map.Entry<Operator, String[]>> , U> {
    protected ComparisonOperator(String fieldName, U fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public List<Map.Entry<Operator, String[]>> getOperatorExpression() {
        List<Map.Entry<Operator, String[]>> list = new ArrayList();
        list.add(new AbstractMap.SimpleImmutableEntry<>(this, new String[]{getEvalExpression(), getFieldName(), getFieldName() + ":" + RandomStringGenerator.randomCharacterNumericString()}));
        return list;
    }

    protected String getEvalExpression(){

        return  "local t = redis.call('ZRANGEBYSCORE', KEYS[1], '" + minumumRangeValue() + "', '"+maximumRangeValue() + "', 'WITHSCORES')\n" +
                        "local i = 1\n"+
                        "local temp = {}\n"+
                        "while(i <= #t) do\n"+
                        "    table.insert(temp, t[i+1])\n"+
                        "    table.insert(temp, t[i])\n"+
                        "    if #temp >= 1000 then\n"+
                        "        redis.call('ZADD', KEYS[2], unpack(temp))\n"+
                        "        temp = {}\n"+
                        "    end\n"+
                        "    i = i+2\n"+
                        "end\n"+
                        "if #temp > 0 then\n"+
                        "    redis.call('ZADD', KEYS[2], unpack(temp))\n"+
                        "end\n"+
                        "redis.call('EXPIRE' , KEYS[2], 100)\n"+
                        "return 1";
    }

    protected String minumumRangeValue(){
        return "-inf";
    }

    protected String maximumRangeValue(){
        return "+inf";
    }

//    public static String sd = "local i = 1\n"+
//            "local temp = {}\n"+
//            "while(i <= #t) do\n"+
//            "    table.insert(temp, t[i+1])\n"+
//            "    table.insert(temp, t[i])\n"+
//            "    if #temp >= 1000 then\n"+
//            "        redis.call('ZADD', KEYS[2], unpack(temp))\n"+
//            "        temp = {}\n"+
//            "    end\n"+
//            "    i = i+2\n"+
//            "end\n"+
//            "if #temp > 0 then\n"+
//            "    redis.call('ZADD', KEYS[2], unpack(temp))\n"+
//            "end\n";

    public StringBuilder toString(String level){
        StringBuilder sb = new StringBuilder();
        sb.append("-"+level+getClass()+ "field: "+ getFieldName() +" - value: "+getFieldValue()+"\n");
        return sb;
    }
}
