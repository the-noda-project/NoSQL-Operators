package gr.ds.unipi.noda.api.core.dataframe;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public abstract class BaseDataframeManipulator {

    public abstract Dataset<Row> spatialView(Dataset<Row> dataset, String location);

    public abstract Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time );

}
