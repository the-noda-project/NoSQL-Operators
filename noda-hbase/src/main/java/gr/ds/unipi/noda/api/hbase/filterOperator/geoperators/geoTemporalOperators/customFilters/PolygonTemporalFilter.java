package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters;

import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators.customFilters.generated.PolygonFilterProtos;
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
    private final List<PolygonFilterProtos.PolygonFilter.Coordinates> coordinates;

    private double longitude = Integer.MIN_VALUE;
    private double latitude = Integer.MIN_VALUE;

    private boolean filterRow = true;


    private PolygonFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, List<PolygonFilterProtos.PolygonFilter.Coordinates> coordinates) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;
        this.coordinates = coordinates;
    }

    public static PolygonFilter newPolygonFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, List<PolygonFilterProtos.PolygonFilter.Coordinates> coordinates){
        return new PolygonFilter(columnFamily, longitudeColumnQualifier,  latitudeColumnQualifier, coordinates);
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

        if (contains(longitude, latitude)) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {

        PolygonFilterProtos.PolygonFilter.Builder builder =
                PolygonFilterProtos.PolygonFilter.newBuilder();
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
        return builder.build().toByteArray();
    }

    public static Filter parseFrom(byte[] pbBytes) throws DeserializationException {

        PolygonFilterProtos.PolygonFilter proto;
        try {
            proto = PolygonFilterProtos.PolygonFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new PolygonFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getCoordinatesList());

    }
}
