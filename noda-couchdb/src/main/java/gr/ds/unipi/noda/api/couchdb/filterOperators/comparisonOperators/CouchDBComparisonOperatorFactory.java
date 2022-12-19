package gr.ds.unipi.noda.api.couchdb.filterOperators.comparisonOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;

import java.util.Date;

public final class CouchDBComparisonOperatorFactory extends BaseComparisonOperatorFactory {
    @Override
    public ComparisonOperator<String, Double> newOperatorGte(String fieldName, double fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorGte(String fieldName, int fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorGte(String fieldName, float fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorGte(String fieldName, short fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorGte(String fieldName, long fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorGte(String fieldName, Date fieldValue) {
        return OperatorGreaterThanEqual.newOperatorGreaterThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Double> newOperatorGt(String fieldName, double fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorGt(String fieldName, int fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorGt(String fieldName, float fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorGt(String fieldName, short fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorGt(String fieldName, long fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorGt(String fieldName, Date fieldValue) {
        return OperatorGreaterThan.newOperatorGreaterThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Double> newOperatorLte(String fieldName, double fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorLte(String fieldName, int fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorLte(String fieldName, float fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorLte(String fieldName, short fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorLte(String fieldName, long fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorLte(String fieldName, Date fieldValue) {
        return OperatorLessThanEqual.newOperatorLessThanEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Double> newOperatorLt(String fieldName, double fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorLt(String fieldName, int fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorLt(String fieldName, float fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorLt(String fieldName, short fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorLt(String fieldName, long fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorLt(String fieldName, Date fieldValue) {
        return OperatorLessThan.newOperatorLessThan(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Double> newOperatorEq(String fieldName, double fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Boolean> newOperatorEq(String fieldName, boolean fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, String> newOperatorEq(String fieldName, String fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorEq(String fieldName, int fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorEq(String fieldName, float fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorEq(String fieldName, short fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorEq(String fieldName, long fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorEq(String fieldName, Date fieldValue) {
        return OperatorEqual.newOperatorEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Double> newOperatorNe(String fieldName, double fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Boolean> newOperatorNe(String fieldName, boolean fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, String> newOperatorNe(String fieldName, String fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Integer> newOperatorNe(String fieldName, int fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Float> newOperatorNe(String fieldName, float fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Short> newOperatorNe(String fieldName, short fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Long> newOperatorNe(String fieldName, long fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }

    @Override
    public ComparisonOperator<String, Date> newOperatorNe(String fieldName, Date fieldValue) {
        return OperatorNotEqual.newOperatorNotEqual(fieldName, fieldValue);
    }
}
