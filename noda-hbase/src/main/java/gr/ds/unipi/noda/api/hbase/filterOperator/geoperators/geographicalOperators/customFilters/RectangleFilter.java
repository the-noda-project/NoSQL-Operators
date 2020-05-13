package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.customFilters.generated.RectangleFilterProtos;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;

import java.io.IOException;

public class RectangleFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;
    private final RectangleFilterProtos.RectangleFilter.Coordinates lowerCoordinates;
    private final RectangleFilterProtos.RectangleFilter.Coordinates upperCoordinates;

    private double longitude = Integer.MIN_VALUE;
    private double latitude = Integer.MIN_VALUE;

    private boolean filterRow = true;


    private RectangleFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, RectangleFilterProtos.RectangleFilter.Coordinates lowerCoordinates, RectangleFilterProtos.RectangleFilter.Coordinates upperCoordinates) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.lowerCoordinates = lowerCoordinates;
        this.upperCoordinates = upperCoordinates;
    }

    public static RectangleFilter newRectangleFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, RectangleFilterProtos.RectangleFilter.Coordinates lowerCoordinates, RectangleFilterProtos.RectangleFilter.Coordinates upperCoordinates){
        return new RectangleFilter(columnFamily, longitudeColumnQualifier,  latitudeColumnQualifier, lowerCoordinates, upperCoordinates);
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

        if(Double.compare(longitude, lowerCoordinates.getLongitude()) == -1 ||  Double.compare(latitude, lowerCoordinates.getLatitude()) == -1){
            return false;
        }
        if(Double.compare(longitude, upperCoordinates.getLongitude()) == 1 ||  Double.compare(latitude, upperCoordinates.getLatitude()) == 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean filterRow() {

        if (contains(longitude, latitude)) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {

        RectangleFilterProtos.RectangleFilter.Builder builder =
                RectangleFilterProtos.RectangleFilter.newBuilder();
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
            builder.setUpperCoordinates(lowerCoordinates);
        }
        return builder.build().toByteArray();
    }

    public static Filter parseFrom(byte[] pbBytes) throws DeserializationException {

        RectangleFilterProtos.RectangleFilter proto;
        try {
            proto = RectangleFilterProtos.RectangleFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new RectangleFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getLowerCoordinates(), proto.getUpperCoordinates());

    }
}
