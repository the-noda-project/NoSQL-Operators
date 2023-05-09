package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

final class ViewResponse {
    @SerializedName("total_rows")
    public Integer totalRows;
    public Integer offset;
    public List<Row> rows;

    public static class Row {
        public String id;
        public JsonElement key;
        public JsonElement value;
        public JsonObject doc;
    }
}
