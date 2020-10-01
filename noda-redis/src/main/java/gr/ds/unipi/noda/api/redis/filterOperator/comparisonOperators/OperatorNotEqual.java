package gr.ds.unipi.noda.api.redis.filterOperator.comparisonOperators;

import gr.ds.unipi.noda.api.redis.filterOperator.RandomStringGenerator;
import gr.ds.unipi.noda.api.redis.filterOperator.Triplet;

import java.util.*;

final class OperatorNotEqual<T> extends ComparisonOperator<T> {

    private OperatorNotEqual(String fieldName, T fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected String getEvalExpression() {
        if(!(getFieldValue() instanceof String)){
            return  "local t1 = redis.call('ZRANGEBYSCORE', KEYS[2], '-inf', '("+getFieldValue() + "')\n" +
                    "local i1 = 1\n"+
                    "local temp1 = {}\n"+
                    "while(i1 <= #t1) do\n"+
                    "    table.insert(temp1, t1[i1+1])\n"+
                    "    table.insert(temp1, t1[i1])\n"+
                    "    if #temp1 >= 1000 then\n"+
                    "        redis.call('SADD', KEYS[3], unpack(temp1))\n"+
                    "        temp1 = {}\n"+
                    "    end\n"+
                    "    i1 = i1+2\n"+
                    "end\n"+
                    "if #temp1 > 0 then\n"+
                    "    redis.call('SADD', KEYS[3], unpack(temp1))\n"+
                    "end\n"+
                    "redis.call('EXPIRE' , KEYS[3], 100)\n"+

                    "local t2 = redis.call('ZRANGEBYSCORE', KEYS[2], '("+getFieldValue() + "', '+inf')\n" +
                    "local i2 = 1\n"+
                    "local temp2 = {}\n"+
                    "while(i2 <= #t2) do\n"+
                    "    table.insert(temp2, t2[i2+1])\n"+
                    "    table.insert(temp2, t2[i2])\n"+
                    "    if #temp2 >= 1000 then\n"+
                    "        redis.call('SADD', KEYS[4], unpack(temp2))\n"+
                    "        temp2 = {}\n"+
                    "    end\n"+
                    "    i2 = i2+2\n"+
                    "end\n"+
                    "if #temp2 > 0 then\n"+
                    "    redis.call('SADD', KEYS[4], unpack(temp2))\n"+
                    "end\n"+
                    "redis.call('EXPIRE' , KEYS[4], 100)\n"+

                    "redis.call('SUNIONSTORE' , KEYS[1], KEYS[3], KEYS[4])\n"+
                    "redis.call('EXPIRE', KEYS[1], 100)\n"+

                    "return 1";
        }
        else{
            return "local t = redis.call('SDIFFSTORE', KEYS[1], KEYS[3], KEYS[2])\n" +
                    "redis.call('EXPIRE' , KEYS[1], 100)\n"+
                    "return 1";
        }
    }

    @Override
    public List<Triplet> getOperatorExpression() {
        List<Triplet> list = new ArrayList();
        if(!(getFieldValue() instanceof String)){
            list.add(Triplet.newTriplet(getEvalExpression(), new String[]{getRandomString(), getFieldName(), RandomStringGenerator.randomCharacterNumericString(), RandomStringGenerator.randomCharacterNumericString()}, new String[]{}));
            return list;
        }
        list.add(Triplet.newTriplet(getEvalExpression(), new String[]{getRandomString(), getFieldName(), "primaryKey"}, new String[]{}));
        return list;
    }

    public static OperatorNotEqual<Double> newOperatorNotEqual(String fieldName, Double fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Integer> newOperatorNotEqual(String fieldName, Integer fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Float> newOperatorNotEqual(String fieldName, Float fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Short> newOperatorNotEqual(String fieldName, Short fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Long> newOperatorNotEqual(String fieldName, Long fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Date> newOperatorNotEqual(String fieldName, Date fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<Boolean> newOperatorNotEqual(String fieldName, Boolean fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

    public static OperatorNotEqual<String> newOperatorNotEqual(String fieldName, String fieldValue) {
        return new OperatorNotEqual(fieldName, fieldValue);
    }

}
