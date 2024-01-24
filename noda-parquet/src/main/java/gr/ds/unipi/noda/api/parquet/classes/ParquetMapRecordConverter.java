package gr.ds.unipi.noda.api.parquet.classes;

import org.apache.parquet.schema.GroupType;


public class ParquetMapRecordConverter extends ParquetRecordConverter {
    public ParquetMapRecordConverter(GroupType schema, String name, ParquetRecordConverter parent) {
        super(schema, name, parent);
    }

    public void start() {
        this.record = new MapRecord();
    }
}