package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

final class DesignDocument {
    public final static String NAME = "NODA";
    public String _id;
    public String _rev;

    public Map<String, View> views = new HashMap<>();

    public boolean hasView(String viewName) {
        return views.containsKey(viewName);
    }

    public void addView(String viewName, String mapFunction, String reduceFunction) {
        views.put(viewName, new View(mapFunction, reduceFunction));
    }

    public static class View {
        @SerializedName("map")
        public String mapFunction;
        @SerializedName("reduce")
        public String reduceFunction;

        View(String map, String reduce) {
            mapFunction = map;
            reduceFunction = reduce;
        }
    }
}
