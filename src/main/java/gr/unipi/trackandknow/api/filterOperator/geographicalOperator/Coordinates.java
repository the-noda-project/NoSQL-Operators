package gr.unipi.trackandknow.api.filterOperator.geographicalOperator;

public class Coordinates {

    private final double longitude;
    private final double latitude;

    private Coordinates(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static Coordinates newCoordinates(double longitude, double latitude) {
        return new Coordinates(longitude, latitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }


}
