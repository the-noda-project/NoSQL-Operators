package gr.ds.unipi.noda.api.yyydatabase.dataframe;

import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class YYYDatabaseDataframeManipulator extends BaseDataframeManipulator {
    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {
        return null;
    }

    @Override
    public Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return null;
    }
}
