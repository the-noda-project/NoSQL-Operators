package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters.generated.CircleTemporalFilterProtos;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class CircleTemporalFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;
    private final CircleTemporalFilterProtos.CircleTemporalFilter.Coordinates centerCoordinates;
    private final double radius;

    private final byte[] columnFamilyTemporal;
    private final byte[] columnQualifierTemporal;
    private final long lowerDateBound;
    private final long upperDateBound;

    private double longitude;
    private double latitude;

    private long date;

    private boolean filterRow = true;


    private CircleTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, CircleTemporalFilterProtos.CircleTemporalFilter.Coordinates centerCoordinates, double radius, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.centerCoordinates = centerCoordinates;
        this.radius = radius;
        this.columnFamilyTemporal = columnFamilyTemporal;
        this.columnQualifierTemporal = columnQualifierTemporal;
        this.lowerDateBound = lowerDateBound;
        this.upperDateBound = upperDateBound;
    }

    public static CircleTemporalFilter newCircleTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, CircleTemporalFilterProtos.CircleTemporalFilter.Coordinates centerCoordinates, double radius, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        return new CircleTemporalFilter(columnFamily, longitudeColumnQualifier, latitudeColumnQualifier, centerCoordinates, radius, columnFamilyTemporal, columnQualifierTemporal, lowerDateBound, upperDateBound);
    }

    @Override
    public void reset() throws IOException {
        longitude = Integer.MIN_VALUE;
        latitude = Integer.MIN_VALUE;
        date = Long.MIN_VALUE;

        filterRow = true;
    }

    @Override
    public ReturnCode filterCell(Cell c) throws IOException {
        if (CellUtil.matchingColumn(c, this.columnFamily, this.longitudeColumnQualifier)) {
            longitude = PrivateCellUtil.getValueAsDouble(c);
        } else if (CellUtil.matchingColumn(c, this.columnFamily, this.latitudeColumnQualifier)) {
            latitude = PrivateCellUtil.getValueAsDouble(c);
        } else if (CellUtil.matchingColumn(c, this.columnFamilyTemporal, this.columnQualifierTemporal)) {
            date = PrivateCellUtil.getValueAsLong(c);
        }
        return ReturnCode.INCLUDE_AND_NEXT_COL;
    }

    @Override
    public boolean hasFilterRow() {
        return true;
    }

    private boolean contains(double longitude, double latitude, long date) {
        if (Double.compare(radius, haversine(longitude, latitude)) != -1 && Long.compare(date, lowerDateBound) != -1 && Long.compare(date, upperDateBound) != 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean filterRow() {

        if (contains(longitude, latitude, date)) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {

        CircleTemporalFilterProtos.CircleTemporalFilter.Builder builder =
                CircleTemporalFilterProtos.CircleTemporalFilter.newBuilder();
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

        if (columnFamilyTemporal != null) {
            builder.setColumnFamilyTemporal(ByteStringer.wrap(columnFamilyTemporal));
        }
        if (columnQualifierTemporal != null) {
            builder.setColumnQualifierTemporal(ByteStringer.wrap(columnQualifierTemporal));
        }

        builder.setLowerDateBound(lowerDateBound);
        builder.setUpperDateBound(upperDateBound);

        return builder.build().toByteArray();
    }

    public static Filter parseFrom(byte[] pbBytes) throws DeserializationException {

        CircleTemporalFilterProtos.CircleTemporalFilter proto;
        try {
            proto = CircleTemporalFilterProtos.CircleTemporalFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new CircleTemporalFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getCenterCoordinates(), proto.getRadius(), proto.getColumnFamilyTemporal().toByteArray(), proto.getColumnQualifierTemporal().toByteArray(), proto.getLowerDateBound(), proto.getUpperDateBound());

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

    public String toString() {
        return String.format("%s (%s, %s, %s, %s, %s, %s, %s, %s)", this.getClass().getSimpleName(), Bytes.toStringBinary(this.columnFamily), Bytes.toStringBinary(this.longitudeColumnQualifier), Bytes.toStringBinary(this.latitudeColumnQualifier), "(" + centerCoordinates.getLongitude() + " " + centerCoordinates.getLatitude() + ")," + radius, Bytes.toStringBinary(this.columnFamilyTemporal), Bytes.toStringBinary(this.columnQualifierTemporal), String.valueOf(lowerDateBound), String.valueOf(upperDateBound));
    }

}
