package gr.ds.unipi.noda.api.parquet.classes;

import org.apache.hadoop.conf.Configuration;
import org.apache.parquet.hadoop.api.InitContext;
import org.apache.parquet.hadoop.api.ReadSupport;
import org.apache.parquet.io.api.RecordMaterializer;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;
import org.bson.Document;

import java.util.List;
import java.util.Map;

public class NoSqlDbReadSupport extends ReadSupport<Document> {

    private final List<String> project;

    public NoSqlDbReadSupport(List<String> project) {
        this.project = project;
    }

    public RecordMaterializer<Document> prepareForRead(Configuration conf, Map<String, String> metaData, MessageType schema, ReadSupport.ReadContext context) {
        return new ParquetRecordMaterializer(schema);
    }

    public ReadSupport.ReadContext init(InitContext context) {

        if(project.size()!=0) {
            StringBuilder sb = new StringBuilder();
            sb.append("message ").append(context.getFileSchema().getName()).append(" {\n");

            for (String s : project) {

                try {
                    String v = context.getFileSchema().getType(s).toString();
                    sb.append(v).append(";").append("\n");
                } catch (org.apache.parquet.io.InvalidRecordException e) {
                }
            }
            sb.append("}");
            return new ReadSupport.ReadContext( MessageTypeParser.parseMessageType(sb.toString()));
        }
        return new ReadSupport.ReadContext(context.getFileSchema());
    }
}