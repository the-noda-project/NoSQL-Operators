package gr.ds.unipi.noda.api.neo4j.dataframe;

import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.*;

public class Neo4jDataframeManipulator extends BaseDataframeManipulator {
    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {

        Dataset<Row> o = dataset.withColumn(location, lit(regexp_replace(col(location), "[p](.*?)\\:|\\,(.*?)\\:|\\'(.*?)\\)", "")));
        Dataset<Row> trimleft = o.withColumn(location, lit(ltrim(col(location))));
        Dataset<Row> trimRight = trimleft.withColumn(location, lit(rtrim(col(location))));

        Dataset<Row> manipulatedDataset = trimRight.withColumn(location, lit(split(col(location), " ")));

//        System.out.println("edw eisai  " + manipulatedDataset.first());
//        System.out.println("================================================================================");
        manipulatedDataset.show();
//        System.out.println(o.first().get(1));
//        System.out.println(manipulatedDataset.first().get(1));
//        System.out.println("================================================================================");

        return manipulatedDataset;
    }


    @Override
    public Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return  spatialView(dataset, location);
    }

}
