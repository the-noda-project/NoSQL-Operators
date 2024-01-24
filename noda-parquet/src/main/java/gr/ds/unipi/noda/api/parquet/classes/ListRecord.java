package gr.ds.unipi.noda.api.parquet.classes;

public class ListRecord extends Record {
    public ListRecord() {
    }

    protected Object toJsonObject() {
        Object[] result = new Object[this.getValues().size()];

        for(int i = 0; i < this.getValues().size(); ++i) {
            result[i] = toJsonValue(((Record.NameValue)this.getValues().get(i)).getValue());
        }

        return result;
    }
}