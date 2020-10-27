package gr.ds.unipi.noda.api.core.dataframe;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public abstract class DataframeManipulator {

    public static BaseDataframeManipulator baseDataframeManipulator;

    public static Dataset<Row> spatialView(Dataset<Row> dataset, String location){
        return baseDataframeManipulator.spatialView(dataset, location);
    }

    public static Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time ){
        return baseDataframeManipulator.trajectoriesTimelapse(dataset, location, time);
    }


}
