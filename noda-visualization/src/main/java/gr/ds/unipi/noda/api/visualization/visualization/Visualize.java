package gr.ds.unipi.noda.api.visualization.visualization;

import gr.ds.unipi.noda.api.visualization.server.ServerManager;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;


public class Visualize {

    public static String datare;

    public static void trajectoriesTimelapse(Dataset<Row> stData) {

        Integer n = (int) (long) stData.count();
        datare = stData.toJSON().showString( 10, 20000, false);

        ServerManager.main(new String[]{});

    }

}
