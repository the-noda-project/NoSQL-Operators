package gr.ds.unipi.noda.api.hbase.dataframe;

import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class YYYDatabaseDataframeManipulator extends BaseDataframeManipulator {
    @Override
    public Dataset<Row> spatialDataframeManipulator(Dataset<Row> dataset, String location) {
        return null;
    }
}
