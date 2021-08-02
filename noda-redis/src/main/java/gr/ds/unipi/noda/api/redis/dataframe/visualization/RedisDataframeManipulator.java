package gr.ds.unipi.noda.api.redis.dataframe.visualization;

import gr.ds.unipi.noda.api.core.dataframe.visualization.BaseDataframeManipulator;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.functions.col;

public class RedisDataframeManipulator extends BaseDataframeManipulator {
    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {

        Dataset<Row> manipulatedDataset = dataset.withColumn(location, array(col(location+":latitude").cast("string"),col(location+":longitude").cast("string")));
        manipulatedDataset.show(20,false);
        manipulatedDataset.printSchema();
        return manipulatedDataset;
    }

    @Override
    public Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return spatialView(dataset, location);
    }
}
