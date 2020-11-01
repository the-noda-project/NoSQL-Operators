package gr.ds.unipi.noda.api.core.hilbert;

public class HilbertUtil {

    public static long[] scaleGeoPoint(double lat, double lon, long max) {
        long x = scale((lat + 90.0f) / 180, max);
        long y = scale((lon + 180.0f) / 360, max);
        return new long[] { x, y };
    }

    public static long[] scaleGeoTemporalPoint(double lat, double lon, long time, long minTime, long maxTime,
                                       long max) {
        long x = scale((lat + 90.0f) / 180, max);
        long y = scale((lon + 180.0f) / 360, max);
        long z = scale(((double) time - minTime) / (maxTime - minTime), max);
        return new long[] { x, y, z };
    }

    private static long scale(double d, long max) {
        if (!(Double.compare(d,0) != -1 &&  Double.compare(d,1) != 1)) {
            throw new IllegalArgumentException();
        }

        if (d == 1) {
            return max;
        } else {
            return Math.round(Math.floor(d * (max + 1)));
        }
    }
}
