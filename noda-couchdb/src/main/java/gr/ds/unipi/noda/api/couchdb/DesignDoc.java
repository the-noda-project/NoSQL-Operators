package gr.ds.unipi.noda.api.couchdb;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
final class DesignDoc {
    public String _id;
    public String _rev;
    public Map<String, Map<String, String>> views;

    private DesignDoc() {
        views = new HashMap<>();
    }

    public static DesignDoc createDesignDoc(View view) {
        DesignDoc designDoc = new DesignDoc();
        designDoc.addView(view);
        return designDoc;
    }

    public void addView(View view) {
        Map<String, String> map = new HashMap<>();
        map.put("map", view.getMapFunction());
        map.put("reduce", view.getReduceFunction());
        views.put(view.getName(), map);
    }
}
