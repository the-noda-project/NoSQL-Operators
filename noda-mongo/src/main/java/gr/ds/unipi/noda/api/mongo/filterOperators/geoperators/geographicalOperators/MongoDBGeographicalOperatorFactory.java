package gr.ds.unipi.noda.api.mongo.filterOperators.geoperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.config.AppConfig;
import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.BaseGeographicalOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.*;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;

public final class MongoDBGeographicalOperatorFactory extends BaseGeographicalOperatorFactory {

    @Override
    public GeographicalOperator newOperatorInGeoPolygon(String fieldName, Polygon polygon) {
        return OperatorInGeoPolygon.newOperatorInGeoPolygon(fieldName, polygon);
    }

    @Override
    public GeographicalOperator newOperatorInGeoRectangle(String fieldName, Rectangle rectangle) {
        return OperatorInGeoRectangle.newOperatorInGeoRectangle(fieldName, rectangle);
    }

    @Override
    public GeographicalOperator newOperatorInGeoCircle(String fieldName, Circle circle) {
        return OperatorInGeoCircle.newOperatorInGeoCircle(fieldName, circle);
    }

    @Override
    public GeographicalOperator newOperatorGeoNearestNeighbors(String fieldName, Point point, int neighbors) {
        return OperatorGeoNearestNeighbors.newOperatorGeoNearestNeighbors(fieldName, point, neighbors);
    }

    public static boolean isOperatorGeoNearestNeighbor(FilterOperator filterOperator) {
        return filterOperator instanceof OperatorGeoNearestNeighbors;
    }

    public static StringBuilder getGeometryExpression(String fieldName, Geometry geometry) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        if (!fieldName.contains(".")) {
            sb.append(fieldName);
        } else {
            sb.append("\"" + fieldName + "\"");
        }

        if (geometry instanceof Rectangle || geometry instanceof Polygon) {
            sb.append(": { $geoWithin: { $geometry: { type:\"Polygon\", coordinates:[ [");

            for (Coordinates c : geometry.getCoordinatesArray()) {
                sb.append(" [");
                sb.append(c.getLongitude());
                sb.append(",");
                sb.append(c.getLatitude());

                sb.append("]");
                sb.append(",");
            }

            //In MongoDB the last point should coincide with the coordinates of the starting point
            sb.append(" [");
            sb.append(geometry.getCoordinatesArray()[0].getLongitude());
            sb.append(",");
            sb.append(geometry.getCoordinatesArray()[0].getLatitude());
            sb.append("]");

            sb.append("] ] } } } }");

            return sb;
        } else if (geometry instanceof Circle) {
            sb.append(": { $geoWithin: { $centerSphere: [");

            sb.append(" [");
            sb.append(((Circle) geometry).getCircleCenter().getLongitude());
            sb.append(", ");
            sb.append(((Circle) geometry).getCircleCenter().getLatitude());
            sb.append("], ");
            sb.append(((Circle) geometry).getRadius() / 6378137);
            sb.append(" ] } } }");

            return sb;

        } else {
            try {
                throw new Exception("Geometry type " + geometry.getClass() + " is not supported");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static StringBuilder getExpressionOfSpatialHilbertIndexes(Rectangle rectangle) {

        final int bits = AppConfig.mongodb().getInt("spatialOp.bits");
        final long maxOrdinates = 1L << bits;

//        final int bits = 13;
//        final long maxOrdinates = 1L << bits;

        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(2);

        long[] lower = HilbertUtil.scaleGeoPoint(rectangle.getLowerBound().getLongitude(), AppConfig.mongodb().getDouble("spatialOp.minLon"), AppConfig.mongodb().getDouble("spatialOp.maxLon"), rectangle.getLowerBound().getLatitude(), AppConfig.mongodb().getDouble("spatialOp.minLat"), AppConfig.mongodb().getDouble("spatialOp.maxLat"), maxOrdinates);
        long[] upper = HilbertUtil.scaleGeoPoint(rectangle.getUpperBound().getLongitude(), AppConfig.mongodb().getDouble("spatialOp.minLon"), AppConfig.mongodb().getDouble("spatialOp.maxLon"), rectangle.getUpperBound().getLatitude(), AppConfig.mongodb().getDouble("spatialOp.minLat"), AppConfig.mongodb().getDouble("spatialOp.maxLat"), maxOrdinates);


        Ranges rangesList = hc.query(lower, upper ,0);


//        Ranges rangesList = hc.query(HilbertUtil.scaleGeoPoint(rectangle.getLowerBound().getLatitude(), rectangle.getLowerBound().getLongitude(), maxOrdinates)
//                , HilbertUtil.scaleGeoPoint(rectangle.getUpperBound().getLatitude(), rectangle.getUpperBound().getLongitude(), maxOrdinates)
//                , 0);

        StringBuilder cb = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        sb.append(" { $or: [ ");

        rangesList.stream().forEach(i -> {
            if (i.low() == i.high()) {
                cb.append(" " + i.low() + ",");
            } else {
                sb.append(" { hilIndex: { $gte: " + i.low() + ", $lte: " + i.high() + " } },");
            }
        });

        if (cb.length() != 0) {
            cb.deleteCharAt(cb.length() - 1);
            sb.append(" { hilIndex: { $in : [" + cb.toString() + "] } }");
        } else {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(" ] }");

        return sb;
    }

}
