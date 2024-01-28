package gr.ds.unipi.noda.api.core.hilbert;

import scala.Tuple3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HilbertUtil {

//    public static long[] scaleGeoPoint(double lat, double lon, long max) {
//        long x = scale((lat + 90.0) / 180, max);
//        long y = scale((lon + 180.0) / 360, max);
//        return new long[]{y,x};
//    }

    public static long[] scaleGeoPoint(double lon, double minLon, double maxLon, double lat, double minLat, double maxLat,
                                       long max) {
        long x = scale((lon - minLon) / (maxLon - minLon), max);
        long y = scale((lat - minLat) / (maxLat - minLat), max);
        return new long[]{x, y};
    }

    public static long[] scaleGeoTemporalPoint(double lon, double minLon, double maxLon, double lat, double minLat, double maxLat, long time, long minTime, long maxTime,
                                               long max) {
        long x = scale((lon - minLon) / (maxLon - minLon), max);
        long y = scale((lat - minLat) / (maxLat - minLat), max);
        long z = scale(((double) time - minTime) / (maxTime - minTime), max);
        return new long[]{x, y, z};
    }


    private static long scale(double d, long max) {
        if (!(Double.compare(d, 0) != -1 && Double.compare(d, 1) != 1)) {
            throw new IllegalArgumentException();
        }

        if (d == 1) {
            return max;
        } else {
            return Math.round(Math.floor(d * (max + 1)));
        }
    }

    public static Optional<Tuple3<Double,Double,Long>[]> liangBarsky(double lineX0, double lineY0, long lineT0, double lineX1, double lineY1, long lineT1,
                                                                     double xMin, double yMin, long tMin, double xMax, double yMax, long tMax){

        double u1 = 0, u2 = 1;

        double dx = lineX1 - lineX0, dy = lineY1 - lineY0;
        long dt = lineT1 - lineT0;

        double p[] = {-dx, dx, -dy, dy, -dt, dt};
        double q[] = {lineX0 - xMin, xMax - lineX0, lineY0 - yMin, yMax - lineY0, lineT0 - tMin, tMax - lineT0};

        for (int i = 0; i < 6; i++) {
            if (p[i] == 0) {
                if (q[i] < 0) {
//                    System.out.println("IT IS NULL 1");
                    return Optional.empty();
                }
            } else {
                double u = (double) q[i] / p[i];
                if (p[i] < 0) {
                    u1 = Math.max(u, u1);
                } else {
                    u2 = Math.min(u, u2);
                }
            }
        }

        if (u1 > u2) {
            return Optional.empty();
        }
        double nx0, ny0, nx1, ny1 ;
        long nt0, nt1;
        nx0 = (lineX0 + u1 * dx);
        ny0 = (lineY0 + u1 * dy);
        nt0 = (long) (lineT0 + u1 * dt);

        nx1 = (lineX0 + u2 * dx);
        ny1 = (lineY0 + u2 * dy);
        nt1 = (long) (lineT0 + u2 * dt);

        List<Tuple3<Double,Double,Long>> stPoints = new ArrayList<>(2);
        Tuple3 stPoint1 =  new Tuple3(nx0, ny0, nt0);
        Tuple3 stPoint2 =  new Tuple3(nx1, ny1, nt1);

        stPoints.add(stPoint1);
        stPoints.add(stPoint2);

        if(stPoints.size()==0){
            try {
                throw new Exception("CANNOT BE EMPTY");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.of(stPoints.toArray(new Tuple3[stPoints.size()]));

    }
}