package gr.ds.unipi.noda.api.visualization.server;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static gr.ds.unipi.noda.api.visualization.visualization.Visualize.dbSystem;

@RestController
public class SqlQueryAPI {
    @RequestMapping(value = "/sql-query", method = RequestMethod.POST)
    public String process(@RequestBody String query) throws Exception {
        System.out.println(query);

        Dataset<Row> result = dbSystem.sql(query).toDataframe();

        result.show();

        return query;
    }
}
