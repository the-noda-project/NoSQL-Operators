package gr.ds.unipi.noda.api.parquet.classes;

import org.apache.parquet.io.api.GroupConverter;
import org.apache.parquet.io.api.RecordMaterializer;
import org.apache.parquet.schema.MessageType;
import org.bson.Document;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;

public class ParquetRecordMaterializer extends RecordMaterializer<Document> {
    public final ParquetRecordConverter root;

    public ParquetRecordMaterializer(MessageType schema) {
        this.root = new ParquetRecordConverter(schema);
    }

    public Document getCurrentRecord() {
        return Document.parse(this.root.getCurrentRecord().toJsonObject().toString().replaceAll("=",":"));
//        return this.root.getCurrentRecord();
    }

    public GroupConverter getRootConverter() {
        return this.root;
    }
}
