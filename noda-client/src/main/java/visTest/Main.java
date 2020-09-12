package visTest;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.server.ServerManager;
import gr.ds.unipi.noda.api.core.visualization.Visualize;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.boot.SpringApplication;

import javax.xml.crypto.Data;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.lt;

public class Main {


    public static void main(String[] args) {
        Visualize.trajectoriesTimelapse(new String[]{});
    }

//    public static void main(String[] args) {
//        SparkSession spark = SparkSession
//                .builder()
//                .appName("Application Name").master("local")
//                .config("spark.neo4j.user","neo4j")
//                .config("spark.neo4j.password", "nikos")
//                .config("spark.neo4j.url","bolt://localhost:7687")
//                .getOrCreate();
//
//
//        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).sparkSession(spark).build();
//        Dataset<Row> dtfr = noSqlDbSystem.operateOn("Ship").filter(and(lt("LAT",-38.31416), lt("LON",145.004403333), gt("SPEED", 20), lt("SPEED", 40))).toDataframe();
//
//        Visualize.trajectoriesTimelapse(dtfr);
//
//        noSqlDbSystem.closeConnection();
//
//    }


}

