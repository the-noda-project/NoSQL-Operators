package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;

import java.util.Date;

public final class CouchDBComparisonOperatorFactory extends BaseComparisonOperatorFactory {
    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorGte(String fieldName, double fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorGte(String fieldName, int fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorGte(String fieldName, float fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorGte(String fieldName, short fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorGte(String fieldName, long fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorGte(String fieldName, Date fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorGt(String fieldName, double fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorGt(String fieldName, int fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorGt(String fieldName, float fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorGt(String fieldName, short fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorGt(String fieldName, long fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorGt(String fieldName, Date fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorLte(String fieldName, double fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorLte(String fieldName, int fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorLte(String fieldName, float fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorLte(String fieldName, short fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorLte(String fieldName, long fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorLte(String fieldName, Date fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorLt(String fieldName, double fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorLt(String fieldName, int fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorLt(String fieldName, float fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorLt(String fieldName, short fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorLt(String fieldName, long fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorLt(String fieldName, Date fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorEq(String fieldName, double fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Boolean> newOperatorEq(String fieldName, boolean fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, String> newOperatorEq(String fieldName, String fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorEq(String fieldName, int fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorEq(String fieldName, float fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorEq(String fieldName, short fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorEq(String fieldName, long fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorEq(String fieldName, Date fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Double> newOperatorNe(String fieldName, double fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Boolean> newOperatorNe(String fieldName, boolean fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, String> newOperatorNe(String fieldName, String fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Integer> newOperatorNe(String fieldName, int fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Float> newOperatorNe(String fieldName, float fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Short> newOperatorNe(String fieldName, short fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Long> newOperatorNe(String fieldName, long fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<FilterStrategy, Date> newOperatorNe(String fieldName, Date fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }
}
