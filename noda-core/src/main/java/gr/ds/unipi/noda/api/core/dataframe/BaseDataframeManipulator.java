package gr.ds.unipi.noda.api.core.dataframe;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public abstract class BaseDataframeManipulator {

    public abstract Dataset<Row> spatialDataframeManipulator(Dataset<Row> dataset, String location);

}
