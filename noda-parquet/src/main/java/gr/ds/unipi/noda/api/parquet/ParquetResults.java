package gr.ds.unipi.noda.api.parquet;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbRecord;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbResults;
import gr.ds.unipi.noda.api.parquet.classes.Record;
import gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators.OperatorInGeoTemporalRectangle;
import org.apache.parquet.hadoop.ParquetReader;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ParquetResults extends NoSqlDbResults<ParquetReader<Document>> {

    private final Supplier<ParquetRecord> f1;
    private final Supplier<Boolean> f2;
    private Document document;
    private final Iterator<Document> refinedResults;
    protected ParquetResults(ParquetReader<Document> noSqlDbResults) {
        super(noSqlDbResults);
        refinedResults = null;

        f1 = (() -> new ParquetRecord(document));
        f2 = (() -> {
            try {
                document = getNoSqlDbResults().read();
                return document != null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    protected ParquetResults(ParquetReader<Document> noSqlDbResults, OperatorInGeoTemporalRectangle operator) {
        super(noSqlDbResults);
        try {
            refinedResults = operator.refinement(noSqlDbResults).iterator();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        f1 = (() -> new ParquetRecord(refinedResults.next()));
        f2 = (refinedResults::hasNext);
    }

    @Override
    public boolean hasNextRecord() {
        return f2.get();
    }

    @Override
    public NoSqlDbRecord getRecord() {
        return f1.get();
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
