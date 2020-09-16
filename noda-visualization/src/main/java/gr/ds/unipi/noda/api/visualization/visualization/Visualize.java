package gr.ds.unipi.noda.api.visualization.visualization;

import gr.ds.unipi.noda.api.visualization.server.ServerManager;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;


public class Visualize {

    public static Dataset<Row> datare;
    public static String stDataToVisualize;

    public static void trajectoriesTimelapse(Dataset<Row> stData) {

        datare = stData;

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"status\": \"ok\", \"data\": [ ");

        datare.collectAsList().forEach(row -> {
            sb.append("{");
            sb.append(" \"id\": " + " \"" + row.get(0) + "\"");
            sb.append(",");
            sb.append(" \"lat\": " + " \"" + row.get(1) + "\"" );
            sb.append(",");
            sb.append(" \"lon\": " + " \"" + row.get(2) + "\"");
            sb.append(",");
            sb.append(" \"time\": " + " \"" + row.get(3) + "\"" );
            sb.append("},");
        });


        sb.append("] }");
        sb.deleteCharAt(sb.lastIndexOf(","));

        stDataToVisualize = sb.toString();

        ServerManager.main(new String[]{});

    }

}
