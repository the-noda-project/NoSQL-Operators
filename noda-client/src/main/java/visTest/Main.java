package visTest;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import gr.ds.unipi.noda.api.visualization.visualization.Visualize;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.lt;

public class Main {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local")
                .config("spark.neo4j.user","neo4j")
                .config("spark.neo4j.password", "nikos")
                .config("spark.neo4j.url","bolt://localhost:7687")
                .getOrCreate();


        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).sparkSession(spark).build();
        Dataset<Row> dtfr = noSqlDbSystem.operateOn("Ship").filter(eq("CRAFT_ID", 	98867615.0)).toDataframe();

        Visualize.trajectoriesTimelapse(dtfr);

        noSqlDbSystem.closeConnection();

    }

}
