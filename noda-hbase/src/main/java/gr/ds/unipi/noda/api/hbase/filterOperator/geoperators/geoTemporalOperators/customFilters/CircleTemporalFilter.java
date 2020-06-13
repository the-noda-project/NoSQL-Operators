package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.generated.CircleFilterProtos;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;

import java.io.IOException;

public class CircleTemporalFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;
    private final CircleFilterProtos.CircleFilter.Coordinates centerCoordinates;
    private final double radius;

    private double longitude = Integer.MIN_VALUE;
    private double latitude = Integer.MIN_VALUE;

    private boolean filterRow = true;


    private CircleFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, CircleFilterProtos.CircleFilter.Coordinates centerCoordinates, double radius) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.centerCoordinates = centerCoordinates;
        this.radius = radius;
    }

    public static CircleFilter newCircleFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, CircleFilterProtos.CircleFilter.Coordinates centerCoordinates, double radius){
        return new CircleFilter(columnFamily, longitudeColumnQualifier,  latitudeColumnQualifier, centerCoordinates, radius);
    }

    @Override
    public void reset() throws IOException {
        filterRow = true;
    }

    @Override
    public ReturnCode filterCell(Cell c) throws IOException {

        if (CellUtil.matchingColumn(c, this.columnFamily, this.longitudeColumnQualifier)) {
            longitude = PrivateCellUtil.getValueAsDouble(c);
        } else if (CellUtil.matchingColumn(c, this.columnFamily, this.latitudeColumnQualifier)) {
            latitude = PrivateCellUtil.getValueAsDouble(c);
        }

        return ReturnCode.INCLUDE;
    }

    private boolean contains(double longitude, double latitude) {
        if (Double.compare(radius, haversine(longitude, latitude)) != -1) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean filterRow() {

        if (contains(longitude, latitude)) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {

        CircleFilterProtos.CircleFilter.Builder builder =
                CircleFilterProtos.CircleFilter.newBuilder();
        if (columnFamily != null) {
            builder.setColumnFamily(ByteStringer.wrap(columnFamily));
        }
        if (longitudeColumnQualifier != null) {
            builder.setLongitudeColumnQualifier(ByteStringer.wrap(longitudeColumnQualifier));
        }
        if (latitudeColumnQualifier != null) {
            builder.setLatitudeColumnQualifier(ByteStringer.wrap(latitudeColumnQualifier));
        }
        if (centerCoordinates != null) {
            builder.setCenterCoordinates(centerCoordinates);
        }
        builder.setRadius(radius);
        return builder.build().toByteArray();
    }

    public static Filter parseFrom(byte[] pbBytes) throws DeserializationException {

        CircleFilterProtos.CircleFilter proto;
        try {
            proto = CircleFilterProtos.CircleFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new CircleFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getCenterCoordinates(), proto.getRadius());

    }

    private double haversine(double lon2, double lat2) {

        double dLat = Math.toRadians(lat2 - this.centerCoordinates.getLatitude());
        double dLon = Math.toRadians(lon2 - this.centerCoordinates.getLongitude());

        double lat1 = Math.toRadians(this.centerCoordinates.getLatitude());
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6378137;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

}
