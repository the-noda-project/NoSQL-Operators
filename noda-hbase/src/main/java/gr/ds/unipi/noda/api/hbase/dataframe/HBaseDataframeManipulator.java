package gr.ds.unipi.noda.api.hbase.dataframe;


import gr.ds.unipi.noda.api.core.dataframe.BaseDataframeManipulator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.array;
import static org.apache.spark.sql.functions.col;


public class HBaseDataframeManipulator extends BaseDataframeManipulator {

    @Override
    public Dataset<Row> spatialView(Dataset<Row> dataset, String location) {

        UDF1 udf1ConvertToDouble = (UDF1<String, Double>) b -> Bytes.toDouble(Bytes.toBytes(b));
        UserDefinedFunction udfConvertToDouble = functions$.MODULE$.udf(udf1ConvertToDouble, DataTypes.DoubleType);

        UDF1 udf1ConvertToLong = (UDF1<String, Long>) b -> Bytes.toLong(Bytes.toBytes(b));
        UserDefinedFunction udfConvertToLong = functions$.MODULE$.udf(udf1ConvertToLong, DataTypes.LongType);

        Dataset<Row> manipulatedDataset = dataset.withColumn(location+":latitude", udfConvertToDouble.apply(new Column(location+":latitude")))
                .withColumn(location+":longitude", udfConvertToDouble.apply(new Column(location+":longitude")))
                .withColumn(location+":date", udfConvertToLong.apply(new Column(location+":date")))
                .withColumn(location, array(col(location+":latitude").cast("string"),col(location+":longitude").cast("string")));
        manipulatedDataset.show(20,false);
        manipulatedDataset.printSchema();
        return manipulatedDataset;
    }

    @Override
    public Dataset<Row> trajectoriesTimelapse(Dataset<Row> dataset, String location, String time) {
        return spatialView(dataset, location);
    }

}
