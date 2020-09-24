package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Double.compare(that.longitude, longitude) != 0) return false;
        return Double.compare(that.latitude, latitude) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(longitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
