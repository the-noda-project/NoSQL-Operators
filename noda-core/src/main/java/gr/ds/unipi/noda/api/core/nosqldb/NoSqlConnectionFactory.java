package gr.ds.unipi.noda.api.core.nosqldb;

import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.ComparisonOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.GeoTemporalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTextualOperators.GeoTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.LogicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.TextualOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.SparkSession;

public abstract class NoSqlConnectionFactory {

    protected NoSqlConnectionFactory() {
        setBaseOperators();
    }

    public abstract NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession);

    public abstract void closeConnection(NoSqlDbConnector noSqlDbConnector);

    public String getDefaultHost() {
        return "localhost";
    }

    public abstract int getDefaultPort();

    public abstract boolean closeConnections();

    private void setBaseOperators() {
        ComparisonOperator.comparisonOperator = getBaseComparisonOperatorFactory();

        GeoSpatialOperator.geoSpatialOperator = getBaseGeoSpatialOperatorFactory();
        GeoTemporalOperator.geoTemporalOperator = getBaseGeoTemporalOperatorFactory();
        GeoTextualOperator.geoTextualOperator = getBaseGeoTextualOperatorFactory();

        LogicalOperator.logicalOperator = getBaseLogicalOperatorFactory();
        AggregateOperator.aggregateOperator = getBaseAggregateOperatorFactory();
        SortOperator.sortOperator = getBaseSortOperatorFactory();

        TextualOperator.textualOperator = getBaseTextualOperatorFactory();
    }

    protected abstract BaseAggregateOperatorFactory getBaseAggregateOperatorFactory();

    protected abstract BaseComparisonOperatorFactory getBaseComparisonOperatorFactory();

    protected abstract BaseGeoSpatialOperatorFactory getBaseGeoSpatialOperatorFactory();
    protected abstract BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory();
    protected abstract BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory();

    protected abstract BaseLogicalOperatorFactory getBaseLogicalOperatorFactory();

    protected abstract BaseSortOperatorFactory getBaseSortOperatorFactory();

    protected abstract BaseTextualOperatorFactory getBaseTextualOperatorFactory();


}
