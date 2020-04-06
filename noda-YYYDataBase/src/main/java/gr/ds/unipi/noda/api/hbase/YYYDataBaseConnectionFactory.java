package gr.ds.unipi.noda.api.hbase;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.BaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.comparisonOperators.BaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.BaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTemporalOperators.BaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoTextualOperators.BaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.logicalOperators.BaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.sortOperators.BaseSortOperatorFactory;
import gr.ds.unipi.noda.api.hbase.aggregateOperator.YYYDataBaseAggregateOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.comparisonOperators.YYYDataBaseComparisonOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.YYYDataBaseGeoSpatialOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoTemporalOperators.YYYDataBaseGeoTemporalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoTextualOperators.YYYDataBaseGeoTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.logicalOperators.YYYDataBaseLogicalOperatorFactory;
import gr.ds.unipi.noda.api.hbase.filterOperator.textualOperators.YYYDataBaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.hbase.sortOperator.YYYDataBaseSortOperatorFactory;
import org.apache.spark.sql.SparkSession;

public final class YYYDataBaseConnectionFactory extends NoSqlConnectionFactory {

    private final YYYDataBaseConnectionManager yYYDataBaseConnectionManager = YYYDataBaseConnectionManager.getInstance();

    @Override
    public NoSqlDbOperators noSqlDbOperators(NoSqlDbConnector connector, String s, SparkSession sparkSession) {
        return null;
    }

    @Override
    public void closeConnection(NoSqlDbConnector noSqlDbConnector) {

    }

    @Override
    public int getDefaultPort() {
        return 0;
    }

    @Override
    public boolean closeConnections() {
        return false;
    }

    @Override
    protected BaseAggregateOperatorFactory getBaseAggregateOperatorFactory() {
        return new YYYDataBaseAggregateOperatorFactory();
    }

    @Override
    protected BaseComparisonOperatorFactory getBaseComparisonOperatorFactory() {
        return new YYYDataBaseComparisonOperatorFactory();
    }

    @Override
    protected BaseGeoSpatialOperatorFactory getBaseGeoSpatialOperatorFactory() {
        return new YYYDataBaseGeoSpatialOperatorFactory();
    }

    @Override
    protected BaseGeoTemporalOperatorFactory getBaseGeoTemporalOperatorFactory() {
        return new YYYDataBaseGeoTemporalOperatorFactory();
    }

    @Override
    protected BaseGeoTextualOperatorFactory getBaseGeoTextualOperatorFactory() {
        return new YYYDataBaseGeoTextualOperatorFactory();
    }

    @Override
    protected BaseLogicalOperatorFactory getBaseLogicalOperatorFactory() {
        return new YYYDataBaseLogicalOperatorFactory();
    }

    @Override
    protected BaseSortOperatorFactory getBaseSortOperatorFactory() {
        return new YYYDataBaseSortOperatorFactory();
    }

    @Override
    protected BaseTextualOperatorFactory getBaseTextualOperatorFactory() {
        return new YYYDataBaseTextualOperatorFactory();
    }
}
