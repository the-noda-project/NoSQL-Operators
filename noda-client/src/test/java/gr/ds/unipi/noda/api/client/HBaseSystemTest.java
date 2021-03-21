package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.junit.Test;

public class HBaseSystemTest {
    //@Ignore
    @Test
    public void hBaseTest() {

        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.HBase().Builder().port(2181).sparkSession(spark).build();
        //noSqlDbSystem.operateOn("points").filter(gte("cf:name", 43.7)).project("cf:name").printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoRectangle("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(25,39))).printScreen();
        //noSqlDbSystem.operateOn("points").filter(inGeoPolygon("location", Coordinates.newCoordinates(24,38),Coordinates.newCoordinates(24,39),Coordinates.newCoordinates(25,39),Coordinates.newCoordinates(25,38))).printScreen();

        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("points");

        NoSqlDbOperators a = noSqlDbOperators.limit(34);

        Dataset<Row> d1 = a.toDataframe();

        //d1 = d1.withColumn("asd",new ColumnName("location:latitude").cast("Double"));

        UDF1 udf1ConvertToString = (UDF1<byte[], String>) Bytes::toString;
        UserDefinedFunction udfConvertToString = functions$.MODULE$.udf(udf1ConvertToString, DataTypes.StringType);

        UDF1 udf1ConvertToDouble = (UDF1<byte[], Double>) Bytes::toDouble;
        UserDefinedFunction udfConvertToDouble = functions$.MODULE$.udf(udf1ConvertToDouble, DataTypes.DoubleType);

        UDF1 udf1ConvertToLong = (UDF1<byte[], Long>) Bytes::toLong;
        UserDefinedFunction udfConvertToLong = functions$.MODULE$.udf(udf1ConvertToLong, DataTypes.LongType);

        d1 = d1.withColumn("newCol",udfConvertToDouble.apply(new Column("location:longitude"))).withColumn("newCol1",udfConvertToDouble.apply(new Column("location:latitude"))).withColumn("newCol2",udfConvertToString.apply(new Column("row")));

        d1.show(false);
        noSqlDbSystem.closeConnection();
        
    }


}
