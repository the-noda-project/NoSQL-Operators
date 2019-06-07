package gr.unipi.trackandknow.api.nosqldb;

import gr.unipi.trackandknow.api.aggregateOperator.AggregateOperators;
import gr.unipi.trackandknow.api.filterOperator.FilterOperator;
import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.*;
import static gr.unipi.trackandknow.api.sortOperator.SortOperators.desc;

public class NoSqlDbSystemTestUsingSpark {

    @Test
    public void test(){

        long timeWindow = 1000 * 60 * 7;

        NoSqlDbSystem.initialize();

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSparkConnectorIntro")
                .getOrCreate();

        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.MongoDB().host("83.212.102.163").database("test").username("myUserAdmin").password("abc123").port(28017).sparkSession(spark).build();
        NoSqlDbOperators noSqlDbOperators = noSqlDbSystem.operateOn("aCollection");

        Dataset<Row> events = noSqlDbOperators.filter(eq("theColumnEvent",1)).toDataframe();

        List<FilterOperator> filterOperatorList = new ArrayList<>();

        events.foreach(row -> {
                    Date d =  row.getAs("theDate");
                    String trajectoryId =row.getAs("idTrajectory");

            FilterOperator fop1 = gte("theDate", new Date(d.getTime() - timeWindow));
            FilterOperator fop2 = lte("theDate", new Date(d.getTime() + timeWindow));
            FilterOperator fop3 = eq("idTrajectory", trajectoryId);

            filterOperatorList.add(and(fop1, fop2, fop3));

        });

        FilterOperator[] fops = filterOperatorList.toArray(new FilterOperator[filterOperatorList.size()]);

        noSqlDbOperators.filter(or(fops)).toDataframe();

        noSqlDbSystem.closeConnection();

    }
}