package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters.generated.PolygonTemporalFilterProtos;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;

import java.io.IOException;
import java.util.List;

public class PolygonTemporalFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;
    private final List<PolygonTemporalFilterProtos.PolygonTemporalFilter.Coordinates> coordinates;

    private final byte[] columnFamilyTemporal;
    private final byte[] columnQualifierTemporal;
    private final long lowerDateBound;
    private final long upperDateBound;

    private double longitude;
    private double latitude;

    private long date;

    private boolean filterRow = true;


    private PolygonTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, List<PolygonTemporalFilterProtos.PolygonTemporalFilter.Coordinates> coordinates, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.coordinates = coordinates;
        this.columnFamilyTemporal = columnFamilyTemporal;
        this.columnQualifierTemporal = columnQualifierTemporal;
        this.lowerDateBound = lowerDateBound;
        this.upperDateBound = upperDateBound;
    }

    public static PolygonTemporalFilter newPolygonTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, List<PolygonTemporalFilterProtos.PolygonTemporalFilter.Coordinates> coordinates, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        return new PolygonTemporalFilter(columnFamily, longitudeColumnQualifier, latitudeColumnQualifier, coordinates, columnFamilyTemporal, columnQualifierTemporal, lowerDateBound, upperDateBound);
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

        if (Long.compare(date, lowerDateBound) == -1 || Long.compare(date, upperDateBound) == 1) {
            return false;
        }

        int i;
        int j;
        boolean result = false;
        for (i = 0, j = coordinates.size() - 1; i < coordinates.size(); j = i++) {
            if ((coordinates.get(i).getLatitude() > latitude) != (coordinates.get(j).getLatitude() > latitude) &&
                    (longitude < (coordinates.get(j).getLongitude() - coordinates.get(i).getLongitude()) * (latitude - coordinates.get(i).getLatitude()) / (coordinates.get(j).getLatitude() - coordinates.get(i).getLatitude()) + coordinates.get(i).getLongitude())) {
                result = !result;
            }
        }
        return result;
    }

    @Override
    public boolean filterRow() {

        if (contains(longitude, latitude, date)) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {

        PolygonTemporalFilterProtos.PolygonTemporalFilter.Builder builder =
                PolygonTemporalFilterProtos.PolygonTemporalFilter.newBuilder();
        if (columnFamily != null) {
            builder.setColumnFamily(ByteStringer.wrap(columnFamily));
        }
        if (longitudeColumnQualifier != null) {
            builder.setLongitudeColumnQualifier(ByteStringer.wrap(longitudeColumnQualifier));
        }
        if (latitudeColumnQualifier != null) {
            builder.setLatitudeColumnQualifier(ByteStringer.wrap(latitudeColumnQualifier));
        }
        if (coordinates != null) {
            builder.addAllCoordinates(coordinates);
        }
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

        PolygonTemporalFilterProtos.PolygonTemporalFilter proto;
        try {
            proto = PolygonTemporalFilterProtos.PolygonTemporalFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new PolygonTemporalFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getCoordinatesList(), proto.getColumnFamilyTemporal().toByteArray(), proto.getColumnQualifierTemporal().toByteArray(), proto.getLowerDateBound(), proto.getUpperDateBound());

    }
}
