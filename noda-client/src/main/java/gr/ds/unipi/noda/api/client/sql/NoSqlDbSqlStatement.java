package gr.ds.unipi.noda.api.client.sql;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class NoSqlDbSqlStatement {

    private NoSqlDbOperators noSqlDbOperators;

    private NoSqlDbSqlStatement(NoSqlDbOperators noSqlDbOperators){
        this.noSqlDbOperators = noSqlDbOperators;
    }

    public Dataset<Row> toDataframe(){
        return noSqlDbOperators.toDataframe();
    }

    public void printScreen(){
        noSqlDbOperators.printScreen();
    }

    public static NoSqlDbSqlStatement newNodaSqlOperators(NoSqlDbOperators noSqlDbOperators){
        return new NoSqlDbSqlStatement(noSqlDbOperators);
    }
}
