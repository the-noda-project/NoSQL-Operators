package gr.ds.unipi.noda.api.visualization.server;


import gr.ds.unipi.noda.api.core.dataframe.DataframeManipulator;
import gr.ds.unipi.noda.api.core.visualization.NoSQLExpression;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static gr.ds.unipi.noda.api.visualization.visualization.Visualize.dbSystem;

@RestController
public class SqlQueryAPI {

    static Dataset<Row> spatialDataset;
    static Dataset<Row> spatioTemporalDataset;

    @RequestMapping(value = "/spatial-sql-query", method = RequestMethod.POST)
    @ResponseBody
    public String spatialSQLQueryPost(@RequestBody Map<String, String> json) throws Exception {
        System.out.println(json.get("query") + " /// " +json.get("idFieldName")  + " /// " +json.get("locationFieldName")  );

        if (json.get("idFieldName") == null) {

            Dataset<Row> result = dbSystem.sql(json.get("query")).toDataframe();



            System.out.println(NoSQLExpression.INSTANCE.getExpression());

            spatialDataset = DataframeManipulator.spatialView(result, json.get("locationFieldName")).select(json.get("locationFieldName"));

            spatialDataset.show();

            StringBuilder sb = new StringBuilder();

            sb.append("{ \"status\": \"ok\", \"data\": [ ");

            spatialDataset.collectAsList().forEach(row -> {

                List<String> locationList = row.getList(0);
                sb.append("{");
                sb.append(" \"lat\": " + " \"" + locationList.get(0) + "\"" );
                sb.append(",");
                sb.append(" \"lon\": " + " \"" + locationList.get(1) + "\"" );
                sb.append("},");
            });


            sb.append("] }");
            sb.deleteCharAt(sb.lastIndexOf(","));

            String spatialResult = sb.toString();



            return spatialResult;

        } else {

            Dataset<Row> result = dbSystem.sql(json.get("query")).toDataframe();

            System.out.println(NoSQLExpression.INSTANCE.getExpression());

            spatialDataset = DataframeManipulator.spatialView(result, json.get("locationFieldName")).select(json.get("idFieldName") ,json.get("locationFieldName"));

            spatialDataset.show();

            StringBuilder sb = new StringBuilder();

            sb.append("{ \"status\": \"ok\", \"data\": [ ");

            spatialDataset.collectAsList().forEach(row -> {

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

            String spatialResult = sb.toString();



            return spatialResult;

        }


    }


    @RequestMapping(value = "/spatiotemporal-sql-query", method = RequestMethod.POST)
    @ResponseBody
    public String spatioTemporalSQLQueryPost(@RequestBody Map<String, String> json) throws Exception {
        System.out.println(json.get("query") + " /// " + json.get("idFieldName") + " /// " + json.get("locationFieldName") + " /// " + json.get("timeFieldName"));

        Dataset<Row> result = dbSystem.sql(json.get("query")).toDataframe();

        System.out.println(NoSQLExpression.INSTANCE.getExpression());

        spatioTemporalDataset = DataframeManipulator.trajectoriesTimelapse(result, json.get("locationFieldName"), json.get("timeFieldName")).select(json.get("idFieldName"),json.get("locationFieldName"),json.get("timeFieldName")).sort(json.get("timeFieldName"));

        spatioTemporalDataset.show();

        StringBuilder sb = new StringBuilder();

        sb.append("{ \"status\": \"ok\", \"data\": [ ");

        spatioTemporalDataset.collectAsList().forEach(row -> {

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

        String spatioTemporalResult = sb.toString();


        return spatioTemporalResult;
    }

}
