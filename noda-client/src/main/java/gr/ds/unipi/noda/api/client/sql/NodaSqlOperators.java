package gr.ds.unipi.noda.api.client.sql;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class NodaSqlOperators {

    private NoSqlDbOperators noSqlDbOperators;

    private NodaSqlOperators(NoSqlDbOperators noSqlDbOperators){
        this.noSqlDbOperators = noSqlDbOperators;
    }

    public Dataset<Row> toDataframe(){
        return noSqlDbOperators.toDataframe();
    }

    public void printScreen(){
        noSqlDbOperators.printScreen();
    }

    public static NodaSqlOperators newNodaSqlOperators(NoSqlDbOperators noSqlDbOperators){
        return new NodaSqlOperators(noSqlDbOperators);
    }
}
