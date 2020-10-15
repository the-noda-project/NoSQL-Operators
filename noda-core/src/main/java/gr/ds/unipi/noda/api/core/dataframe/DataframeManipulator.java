package gr.ds.unipi.noda.api.core.dataframe;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public abstract class DataframeManipulator {

    public static BaseDataframeManipulator baseDataframeManipulator;

    public static Dataset<Row> spatialDataframeManipulator(Dataset<Row> dataset, String location){
        return baseDataframeManipulator.spatialDataframeManipulator(dataset, location);
    }

}
