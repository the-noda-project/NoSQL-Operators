package visTest;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import gr.ds.unipi.noda.api.visualization.visualization.Visualize;

import java.util.Date;

import static gr.ds.unipi.noda.api.core.operators.FilterOperators.*;
import static gr.ds.unipi.noda.api.core.operators.FilterOperators.lt;

public class Main {

    public static NoSqlDbSystem noSqlDbSystem;

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Application Name").master("local")
                .config("spark.neo4j.user","neo4j")
                .config("spark.neo4j.password", "nikos")
                .config("spark.neo4j.url","bolt://localhost:7687")
                .getOrCreate();

        Date datemax = new Date(1547078400);
        Date datemin = new Date(1546992000);

        noSqlDbSystem = NoSqlDbSystem.Neo4j().Builder("neo4j", "nikos").host("localhost").port(7687).sparkSession(spark).build();

        Visualize.startQueryVisualization(noSqlDbSystem);

//        Dataset<Row> dtfr = noSqlDbSystem.operateOn("Ship").filter(and(lt("LAT",-38.31416), lt("LON",145.004403333), gt("SPEED", 20), lt("SPEED", 40))).toDataframe().sort("c");


//       Dataset<Row> dtfr =  noSqlDbSystem.operateOn("Ship").filter(inGeoTemporalRectangle("spatialPoint", Coordinates.newCoordinates( -118.54179, 33.82936), Coordinates.newCoordinates( -118.44566, 33.93083), "secondTimestamp",  datemin, datemax)).toDataframe();


        //main example
//        Dataset<Row> dtfr =  noSqlDbSystem.operateOn("Ship").filter(or(eq("MMSI", 	538002283), eq("MMSI", 		338822000))).toDataframe();
//        Visualize.trajectoriesTimelapse(dtfr, "MMSI", "spatialPoint", "secondTimestamp");


//        Visualize.spatialView(dtfr, "spatialPoint");
//        Visualize.spatialView(dtfr, "MMSI", "spatialPoint");

        noSqlDbSystem.closeConnection();

    }


}
