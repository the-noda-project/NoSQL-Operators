package gr.ds.unipi.noda.api.visualization.visualization;

import gr.ds.unipi.noda.api.core.dataframe.DataframeManipulator;
import gr.ds.unipi.noda.api.visualization.server.ServerManager;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.util.List;

public class Visualize {

    public static Dataset<Row> datare;
    public static String stDataToVisualize;
    public static String spatialDataToVisualize;

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
