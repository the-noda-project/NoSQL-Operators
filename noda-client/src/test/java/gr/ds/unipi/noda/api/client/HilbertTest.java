package gr.ds.unipi.noda.api.client;

import com.github.davidmoten.guavamini.Preconditions;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.SmallHilbertCurve;
import org.junit.Test;

import java.text.ParseException;

public class HilbertTest {

    public static NoSqlDbSystem noSqlDbSystem;

    @Test
    public void hilTest() throws ParseException {
        float lat1 = 34.936015f;
        float lon1 = 19.685170f;
        long minTime = 1534280400000L;
        long maxTime = 1535749199999L;
        long t1 = 1534280405000L;
        float lat2 = 41.706090f;
        float lon2 = 28.240304f;
        long t2 = 1535745599000L;
        int bits = 2;
        int dimensions = 3;
        SmallHilbertCurve h = HilbertCurve.small().bits(bits).dimensions(dimensions);
        long maxOrdinates = 1L << bits;
        long[] point1 = scalePoint(lat1, lon1, t1, minTime, maxTime, maxOrdinates);
        long[] point2 = scalePoint(lat2, lon2, t2, minTime, maxTime, maxOrdinates);


        h.query(point1, point2, 0);

    }

    public static long[] scalePoint(float lat, float lon, long time, long minTime, long maxTime,
                                    long max) {
        long x = scale((lat + 90.0f) / 180, max);
        long y = scale((lon + 180.0f) / 360, max);
        long z = scale(((float) time - minTime) / (maxTime - minTime), max);
        return new long[] { x, y, z };
    }

    private static long scale(float d, long max) {
        Preconditions.checkArgument(d >= 0 && d <= 1);
        if (d == 1) {
            return max;
        } else {
            return Math.round(Math.floor(d * (max + 1)));
        }
    }
}
