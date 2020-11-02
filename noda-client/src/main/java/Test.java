import gr.ds.unipi.noda.api.client.NoSqlDbSystem;

public class Test {
    public static void main(String[] args){
        NoSqlDbSystem noSqlDbSystem = NoSqlDbSystem.Redis().Builder().build();

        noSqlDbSystem.sql("SELECT* FROM Ship WHERE GEO_CIRCLE_KM(spatialPoint, (-122.5993238, 37.7995747), 1)");
        noSqlDbSystem.closeConnection();
    }
}
