package gr.ds.unipi.noda.api.core.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static gr.ds.unipi.noda.api.core.visualization.Visualize.datare;

@RestController
public class NodaTrajectoriesAPI {

    private String without1;
    private String without2;
    private String without3;
    private String without4;
    private String response;


    @RequestMapping(value = "/noda-trajectories-timelapse", produces = "text/plain")
    public String nodaTrajectoriesTimelapse() {

        without1 = datare.replace("+" , "");
        without2 = without1.replace("|" , "");
        without3 = without2.replace("-" , "");
        without4 = without3.replace("value" , "");
        response = without4;

        return response;
    }

}
