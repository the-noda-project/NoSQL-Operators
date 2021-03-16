package gr.ds.unipi.noda.api.hbase.dataframe;


import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.types.DataTypes;


public class HBaseDataframeManipulator extends BaseDataframeManipulator {

    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {
        dataset = dataset.withColumn(location, dataset.col(location).cast(DataTypes.LongType));
        dataset.show();
        return dataset;
    }

    @Override
    public Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {

        return null;
    }

}
