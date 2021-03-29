package gr.ds.unipi.noda.api.mongo.dataframe;

import gr.ds.unipi.noda.api.core.dataframe.visualization.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.*;

public class MongoDBDataframeManipulator extends BaseDataframeManipulator {

    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {

        dataset = dataset.withColumn(location, dataset.col(location).cast("string"));
        Dataset<Row> manipulatedDataset = dataset.withColumn(location, lit(regexp_replace(col(location), "\\, Point", "")))
                                .withColumn(location, lit(regexp_replace(col(location), "\\[", "")))
                                .withColumn(location, lit(regexp_replace(col(location), "\\]", "")))
                                .withColumn(location, lit(regexp_replace(col(location), "\\,", "")))
                                .withColumn(location, lit(split(col(location), " ")))
                                .withColumn("lat",  col(location).getItem(1)).withColumn("lon", col(location).getItem(0))
                                .withColumn(location, array(col("lat"), col("lon")));


        manipulatedDataset.show(20,false);
        manipulatedDataset.printSchema();
        return manipulatedDataset;
    }

    @Override
    public  Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return spatialView(dataset, location);
    }

}
