package gr.ds.unipi.noda.api.visualization.server;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SqlQueryAPI {
    @RequestMapping(value = "/sql-query", method = RequestMethod.POST)
    public String process(@RequestBody String query) throws Exception {
        System.out.println(query);


        return query;
    }
}
