package gr.unipi.noda.api.redis.filterOperator.comparisonOperator;

import gr.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;

import java.util.Date;

/**
 * @author adimo on 10/10/2019
 */
public class RedisComparisonOperatorFactory extends BaseComparisonOperatorFactory {
    @Override
    public ComparisonOperator newOperatorGte(String fieldName, double fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGte(String fieldName, int fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGte(String fieldName, float fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGte(String fieldName, short fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGte(String fieldName, long fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGte(String fieldName, Date fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue.getTime());
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, double fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, int fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, float fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, short fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, long fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorGt(String fieldName, Date fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue.getTime());
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, double fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, int fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, float fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, short fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, long fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLte(String fieldName, Date fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue.getTime());
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, double fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, int fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, float fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, short fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, long fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorLt(String fieldName, Date fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue.getTime());
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, double fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, boolean fieldValue) {
        throw new UnsupportedOperationException("RediSearch boolean filtering is not supported");
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, String fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, int fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, float fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, short fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, long fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorEq(String fieldName, Date fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue.getTime());
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, double fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, boolean fieldValue) {
        throw new UnsupportedOperationException("RediSearch boolean filtering is not supported");
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, String fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, int fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, float fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, short fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, long fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator newOperatorNe(String fieldName, Date fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue.getTime());
    }
}
