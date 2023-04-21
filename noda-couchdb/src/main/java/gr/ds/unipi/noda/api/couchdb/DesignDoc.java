package gr.ds.unipi.noda.api.couchdb;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
final class DesignDoc {
    public final String _id = null;
    public final String _rev = null;
    public final Map<String, Map<String, String>> views = new HashMap<>();

    public void addView(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("map", view.getMapFunction());
        map.put("reduce", view.getReduceFunction());
        views.put(view.getName(), map);
    }

    public Map<String, String> getView(View view) {
        return views.get(view.getName());
    }

    public boolean hasView(View view) {
        return views.containsKey(view.getName());
    }
}
