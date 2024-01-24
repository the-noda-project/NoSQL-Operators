package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.parquet.classes.Record;
import org.apache.parquet.hadoop.ParquetReader;
import org.bson.Document;

import java.io.IOException;

public class ParquetResults extends NoSqlDbResults<ParquetReader<Document>> {
//    private Record record;
    protected ParquetResults(ParquetReader<Document> noSqlDbResults) {
        super(noSqlDbResults);
    }

    @Override
    public boolean hasNextRecord() {
        throw new UnsupportedOperationException("hasNextRecord method is not supported...");
    }

    @Override
    public NoSqlDbRecord getRecord() {
        try {
            return new ParquetRecord(getNoSqlDbResults().read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            getNoSqlDbResults().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
