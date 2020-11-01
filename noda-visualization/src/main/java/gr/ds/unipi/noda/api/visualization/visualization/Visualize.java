package gr.ds.unipi.noda.api.visualization.visualization;

import gr.ds.unipi.noda.api.client.NoSqlDbSystem;
import gr.ds.unipi.noda.api.core.dataframe.DataframeManipulator;
import gr.ds.unipi.noda.api.visualization.server.ServerManager;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.List;

public class Visualize {

    public static gr.ds.unipi.noda.api.client.NoSqlDbSystem dbSystem;
    public static Dataset<Row> datare;
    public static String stDataToVisualize;
    public static String spatialDataToVisualize;

    public static void startQueryVisualization(gr.ds.unipi.noda.api.client.NoSqlDbSystem noSqlDbSystem) {

        ServerManager.main(new String[]{});

        dbSystem = noSqlDbSystem;
//        noSqlDbSystem.sql("SELECT* FROM geoPoints WHERE GEO_TEMPORAL_CIRCLEKM(location, (-122.5993238, 37.7995747), 47.90, date, '5/9/2019 00:00:00', '5/9/2019 23:59:50')").toDataframe();

    }

    public static void trajectoriesTimelapse(Dataset<Row> stData, String idName, String locationName, String timestampName) {

        datare = DataframeManipulator.trajectoriesTimelapse(stData, locationName, timestampName).select(idName,locationName,timestampName).sort(timestampName);

        datare.show();

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"status\": \"ok\", \"data\": [ ");

        datare.collectAsList().forEach(row -> {

           List<String> locationList = row.getList(1);

            sb.append("{");
            sb.append(" \"id\": " + " \"" + row.get(0) + "\"");
            sb.append(",");
            sb.append(" \"lat\": " + " \"" + locationList.get(0) + "\"" );
            sb.append(",");
            sb.append(" \"lon\": " + " \"" + locationList.get(1) + "\"");
            sb.append(",");
            sb.append(" \"time\": " + " \"" + row.get(2) + "\"");
            sb.append("},");
        });


        sb.append("] }");
        sb.deleteCharAt(sb.lastIndexOf(","));

        stDataToVisualize = sb.toString();

        ServerManager.main(new String[]{});

    }

    public static void spatialView(Dataset<Row> stData, String idName, String locationName) {


        datare = DataframeManipulator.spatialView(stData, locationName).select(idName,locationName);

        datare.show();

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"status\": \"ok\", \"data\": [ ");

        datare.collectAsList().forEach(row -> {

            List<String> locationList = row.getList(1);

            sb.append("{");
            sb.append(" \"id\": " + " \"" + row.get(0) + "\"");
            sb.append(",");
            sb.append(" \"lat\": " + " \"" + locationList.get(0) + "\"" );
            sb.append(",");
            sb.append(" \"lon\": " + " \"" + locationList.get(1) + "\"" );
            sb.append("},");
        });


        sb.append("] }");
        sb.deleteCharAt(sb.lastIndexOf(","));

        spatialDataToVisualize = sb.toString();

        ServerManager.main(new String[]{});

    }

    public static void spatialView(Dataset<Row> stData, String locationName) {


        datare = DataframeManipulator.spatialView(stData, locationName).select(locationName);

        datare.show();

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"status\": \"ok\", \"data\": [ ");

        datare.collectAsList().forEach(row -> {

            List<String> locationList = row.getList(0);

            sb.append("{");
            sb.append(" \"lat\": " + " \"" + locationList.get(0) + "\"" );
            sb.append(",");
            sb.append(" \"lon\": " + " \"" + locationList.get(1) + "\"" );
            sb.append("},");
        });


        sb.append("] }");
        sb.deleteCharAt(sb.lastIndexOf(","));

        spatialDataToVisualize = sb.toString();

        ServerManager.main(new String[]{});

    }


}
