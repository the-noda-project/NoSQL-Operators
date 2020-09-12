package gr.ds.unipi.noda.api.core.server.NodaTrajectoriesAPI;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class NodaTrajectoriesAPI {


    @RequestMapping(value = "/noda-trajectories-timelapse", produces = "text/plain")
    public static List<Model> nodaTrajectoriesTimelapse(Dataset<Row> tsData) {
        return Arrays.asList(
                new Model(tsData.toJSON().toString())
        );
    }

}
