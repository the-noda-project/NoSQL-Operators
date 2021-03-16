package gr.ds.unipi.noda.api.mongo.dataframe;

import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.*;

public class MongoDBDataframeManipulator extends BaseDataframeManipulator {

    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {

        dataset = dataset.withColumn(location, dataset.col(location).cast("string"));
        Dataset<Row> o = dataset.withColumn(location, lit(regexp_replace(col(location), "\\, Point", "")));
        Dataset<Row> s = o.withColumn(location, lit(regexp_replace(col(location), "\\[", "")));
        Dataset<Row> k = s.withColumn(location, lit(regexp_replace(col(location), "\\]", "")));
        Dataset<Row> x = k.withColumn(location, lit(regexp_replace(col(location), "\\,", "")));
        Dataset<Row> manipulatedDataset = x.withColumn(location, lit(split(col(location), " ")));

        manipulatedDataset.show(20,false);
        return manipulatedDataset;
    }

    @Override
    public  Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return spatialView(dataset, location);
    }

}
