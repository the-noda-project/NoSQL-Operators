package gr.ds.unipi.noda.api.core.visualization;

import gr.ds.unipi.noda.api.core.server.ServerManager;
import org.apache.spark.InterruptibleIterator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Visualize {

    public static String datare;

    public static void trajectoriesTimelapse(Dataset<Row> stData) {

        Integer n = (int) (long) stData.count();
        datare = stData.toJSON().showString( 10, 20000, false);

        ServerManager.main(new String[]{});

    }

}
