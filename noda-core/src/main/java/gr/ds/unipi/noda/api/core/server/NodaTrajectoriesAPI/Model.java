package gr.ds.unipi.noda.api.core.server.NodaTrajectoriesAPI;

public class Model {

    private String tsData;

    public Model(String tsData) {
        this.tsData = tsData;

    }

    public String getTsData() {
        return tsData;
    }

    public void setTsData(String tsData) {
        this.tsData = tsData;
    }


}
