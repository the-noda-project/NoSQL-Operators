package gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators;

import java.util.Date;

public abstract class BaseComparisonOperatorFactory {

    public abstract ComparisonOperator newOperatorGte(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorGte(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorGte(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorGte(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorGte(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorGte(String fieldName, Date fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorGt(String fieldName, Date fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorLte(String fieldName, Date fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorLt(String fieldName, Date fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, boolean fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, String fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorEq(String fieldName, Date fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, double fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, boolean fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, String fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, int fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, float fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, short fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, long fieldValue);

    public abstract ComparisonOperator newOperatorNe(String fieldName, Date fieldValue);

}
