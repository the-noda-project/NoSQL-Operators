package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators;

import gr.ds.unipi.noda.api.core.constants.Commons;
import gr.ds.unipi.sttk.kNNOverRangeQueries.gridPartitioning.LoadHistogram;
import gr.ds.unipi.sttk.kNNOverRangeQueries.gridPartitioning.RadiusDetermination;

public final class HistogramInstance {
    private static HistogramInstance histogramInstance;
    private static RadiusDetermination radiusDetermination;

    public HistogramInstance() {
        LoadHistogram histogram = LoadHistogram.newLoadHistogram(Commons.BASE_PATH);
        radiusDetermination = RadiusDetermination.newRadiusDetermination(histogram.getHistogram(),
                histogram.getNumberOfCellsxAxis(), histogram.getNumberOfCellsyAxis(), histogram.getMinx(),
                histogram.getMiny(), histogram.getMaxx(), histogram.getMaxy());
    }

    public static HistogramInstance getHistogram() {
        if(histogramInstance == null)
            histogramInstance = new HistogramInstance();
        return histogramInstance;
    }

    public double findRadius(double longitude, double latitude, long neighboors) {
        return radiusDetermination.findRadius(longitude, latitude, neighboors);
    }
}
