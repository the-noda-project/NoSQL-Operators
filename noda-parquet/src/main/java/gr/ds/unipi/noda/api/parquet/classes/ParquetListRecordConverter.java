package gr.ds.unipi.noda.api.parquet.classes;

import org.apache.parquet.schema.GroupType;

public class ParquetListRecordConverter extends ParquetRecordConverter {
    public ParquetListRecordConverter(GroupType schema, String name, ParquetRecordConverter parent) {
        super(schema, name, parent);
    }

    public void start() {
        this.record = new ListRecord();
    }
}
