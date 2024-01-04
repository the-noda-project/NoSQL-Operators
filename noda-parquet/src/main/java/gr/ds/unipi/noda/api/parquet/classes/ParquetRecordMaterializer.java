package gr.ds.unipi.noda.api.parquet.classes;

import gr.ds.unipi.noda.api.parquet.ParquetRecord;
import org.apache.parquet.io.api.GroupConverter;
import org.apache.parquet.io.api.RecordMaterializer;
import org.apache.parquet.schema.MessageType;

public class ParquetRecordMaterializer extends RecordMaterializer<ParquetRecord> {
    public final ParquetRecordConverter root;

    public ParquetRecordMaterializer(MessageType schema) {
        this.root = new ParquetRecordConverter(schema);
    }

    public ParquetRecord getCurrentRecord() {
        return this.root.getCurrentRecord();
    }

    public GroupConverter getRootConverter() {
        return this.root;
    }
}
