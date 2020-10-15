package gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;

import static java.lang.Math.cos;

public class Circle extends Geometry {

    private final double radius; //stored in meters unit

    private Circle(Coordinates[] coordinatesArray, double radius) {
        super(coordinatesArray);
        this.radius = radius;
    }

    public static Circle newCircle(Coordinates coordinates, double radius) {
        return new Circle(new Coordinates[]{coordinates}, radius);
    }

    public Coordinates getCircleCenter() {
        return getCoordinatesArray()[0];
    }

    public double getRadius() {
        return radius;
    }

    public Rectangle getMbr() {

        double earth = 6378.137;  //radius of the earth in kilometer
        double pi = Math.PI;
        double m = (1 / ((2 * pi / 360) * earth)) / 1000;  //1 meter in degree

        Coordinates lowerBound = Coordinates.newCoordinates(getCircleCenter().getLongitude() - (radius * m) / cos(getCircleCenter().getLatitude() * (pi / 180)), getCircleCenter().getLatitude() - (getRadius() * m));
        Coordinates upperBound = Coordinates.newCoordinates(getCircleCenter().getLongitude() + (radius * m) / cos(getCircleCenter().getLatitude() * (pi / 180)), getCircleCenter().getLatitude() + (getRadius() * m));

        return Rectangle.newRectangle(lowerBound, upperBound);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o) && Double.compare(((Circle )o).radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

//    public boolean contains(Point point) {
//
//        if (Double.compare(radius, haversine(getCircleCenter().getLongitude(), getCircleCenter().getLatitude(), point.getPoint().getLongitude(), point.getPoint().getLatitude())) != -1) {
//            return true;
//        }
//        return false;
//    }
//
//    private static double haversine(double lon1, double lat1, double lon2, double lat2) {
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLon = Math.toRadians(lon2 - lon1);
//
//        lat1 = Math.toRadians(lat1);
//        lat2 = Math.toRadians(lat2);
//
//        double a = Math.pow(Math.sin(dLat / 2), 2) +
//                Math.pow(Math.sin(dLon / 2), 2) *
//                        Math.cos(lat1) *
//                        Math.cos(lat2);
//        double rad = 6378137;
//        double c = 2 * Math.asin(Math.sqrt(a));
//        return rad * c;
//    }

}