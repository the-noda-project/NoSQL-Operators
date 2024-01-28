package gr.ds.unipi.noda.api.client.parquet;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.client.sql.NoSqlDbSqlStatement;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;
import org.junit.Test;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;

public class ParquetSystemTest {
    @Test
    public void parquetTest() {

//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Application Name").master("local")
//                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Parquet().Builder().host("filesystem").build();

        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("points").filter(ne("",true));
//        NoSqlDbSqlStatement a = noSqlDbSystem.sql("SELECT * FROM passengerCars WHERE GEO_RECTANGLE( location , ( (22.420005798339844, 37.06873843120686 ), ( 22.441120147705078 , 37.06873843120686 ) ) )");

        NoSqlDbResults results = noSqlDbOperators.getResults();
        NoSqlDbRecord record;

        int i=0;
        while (results.hasNextRecord()){
            record = results.getRecord();
//            System.out.println(record.getString("objectId") +" - "+ i);
            i++;
        }

        results.close();
        noSqlDbSystem.closeConnection();
    }


}
