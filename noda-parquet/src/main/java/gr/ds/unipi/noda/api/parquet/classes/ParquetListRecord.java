package gr.ds.unipi.noda.api.parquet.classes;

import gr.ds.unipi.noda.api.parquet.ParquetRecord;

public class ParquetListRecord extends ParquetRecord {
    public ParquetListRecord() {
    }

    protected Object toJsonObject() {
        Object[] result = new Object[this.getValues().size()];

        for(int i = 0; i < this.getValues().size(); ++i) {
            result[i] = toJsonValue(((ParquetRecord.NameValue)this.getValues().get(i)).getValue());
        }

        return result;
    }
}