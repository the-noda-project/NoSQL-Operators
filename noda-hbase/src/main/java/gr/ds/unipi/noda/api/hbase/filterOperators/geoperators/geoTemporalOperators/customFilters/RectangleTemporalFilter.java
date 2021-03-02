package gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperators.geoperators.geoTemporalOperators.customFilters.generated.RectangleTemporalFilterProtos;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class RectangleTemporalFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;
    private final RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates lowerCoordinates;
    private final RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates upperCoordinates;

    private final byte[] columnFamilyTemporal;
    private final byte[] columnQualifierTemporal;
    private final long lowerDateBound;
    private final long upperDateBound;

    private double longitude;
    private double latitude;

    private long date;

    private boolean filterRow = true;


    private RectangleTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates lowerCoordinates, RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates upperCoordinates, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.lowerCoordinates = lowerCoordinates;
        this.upperCoordinates = upperCoordinates;
        this.columnFamilyTemporal = columnFamilyTemporal;
        this.columnQualifierTemporal = columnQualifierTemporal;
        this.lowerDateBound = lowerDateBound;
        this.upperDateBound = upperDateBound;
    }

    public static RectangleTemporalFilter newRectangleTemporalFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates lowerCoordinates, RectangleTemporalFilterProtos.RectangleTemporalFilter.Coordinates upperCoordinates, byte[] columnFamilyTemporal, byte[] columnQualifierTemporal, long lowerDateBound, long upperDateBound) {
        return new RectangleTemporalFilter(columnFamily, longitudeColumnQualifier, latitudeColumnQualifier, lowerCoordinates, upperCoordinates, columnFamilyTemporal, columnQualifierTemporal, lowerDateBound, upperDateBound);
    }

    @Override
    public void reset() throws IOException {
        longitude = Integer.MIN_VALUE;
        latitude = Integer.MIN_VALUE;
        date =Long.MIN_VALUE;

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

    private boolean contains(double longitude, double latitude, long date) {

        if (Double.compare(longitude, lowerCoordinates.getLongitude()) == -1 || Double.compare(latitude, lowerCoordinates.getLatitude()) == -1 || Long.compare(date, lowerDateBound) == -1) {
            return false;
        }
        if (Double.compare(longitude, upperCoordinates.getLongitude()) == 1 || Double.compare(latitude, upperCoordinates.getLatitude()) == 1 || Long.compare(date, upperDateBound) == 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean filterRow() {
        if (contains(longitude, latitude, date)) {
            filterRow = false;
        }
        return filterRow;
    }

    @Override
    public boolean hasFilterRow(){
        return true;
    }

    public byte[] toByteArray() throws IOException {

        RectangleTemporalFilterProtos.RectangleTemporalFilter.Builder builder =
                RectangleTemporalFilterProtos.RectangleTemporalFilter.newBuilder();
        if (columnFamily != null) {
            builder.setColumnFamily(ByteStringer.wrap(columnFamily));
        }
        if (longitudeColumnQualifier != null) {
            builder.setLongitudeColumnQualifier(ByteStringer.wrap(longitudeColumnQualifier));
        }
        if (latitudeColumnQualifier != null) {
            builder.setLatitudeColumnQualifier(ByteStringer.wrap(latitudeColumnQualifier));
        }
        if (lowerCoordinates != null) {
            builder.setLowerCoordinates(lowerCoordinates);
        }
        if (upperCoordinates != null) {
            builder.setUpperCoordinates(upperCoordinates);
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

        RectangleTemporalFilterProtos.RectangleTemporalFilter proto;
        try {
            proto = RectangleTemporalFilterProtos.RectangleTemporalFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new RectangleTemporalFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getLowerCoordinates(), proto.getUpperCoordinates(), proto.getColumnFamilyTemporal().toByteArray(), proto.getColumnQualifierTemporal().toByteArray(), proto.getLowerDateBound(), proto.getUpperDateBound());

    }
}
