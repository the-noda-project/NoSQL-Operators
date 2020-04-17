package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.Coordinates;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Point;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Polygon;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.PrivateCellUtil;
import org.apache.hadoop.hbase.exceptions.DeserializationException;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterBase;
import org.apache.hadoop.hbase.util.ByteStringer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class PolygonFilter extends FilterBase {

    private final byte[] columnFamily;
    private final byte[] longitudeColumnQualifier;
    private final byte[] latitudeColumnQualifier;

    private double longitude = Integer.MAX_VALUE;
    private double latitude = Integer.MIN_VALUE;

    private final byte[] polygon;
    private Polygon polygonDes;
    private boolean filterRow = true;


    private PolygonFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, byte[] polygon) {
        this.columnFamily = columnFamily;
        this.longitudeColumnQualifier = longitudeColumnQualifier;
        this.latitudeColumnQualifier = latitudeColumnQualifier;

        this.polygon = polygon;

        //forming deserialized polygon
        ByteArrayInputStream bis = new ByteArrayInputStream(polygon);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            polygonDes = (Polygon) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
    }

    public static PolygonFilter newPolygonFilter(byte[] columnFamily, byte[] longitudeColumnQualifier, byte[] latitudeColumnQualifier, byte[] polygon){
        return new PolygonFilter(columnFamily, longitudeColumnQualifier,  latitudeColumnQualifier, polygon);
    }

    @Override
    public void reset() throws IOException {
        filterRow = true;
    }

    @Override
    public Filter.ReturnCode filterCell(Cell c) throws IOException {

        if (CellUtil.matchingColumn(c, this.columnFamily, this.longitudeColumnQualifier)) {
            longitude = PrivateCellUtil.getValueAsDouble(c);
        } else if (CellUtil.matchingColumn(c, this.columnFamily, this.latitudeColumnQualifier)) {
            latitude = PrivateCellUtil.getValueAsDouble(c);
        }

        return Filter.ReturnCode.INCLUDE;
    }

    @Override
    public boolean filterRow() {
        if (polygonDes.contains(Point.newPoint(Coordinates.newCoordinates(longitude, latitude)))) {
            filterRow = false;
        }
        return filterRow;
    }

    public byte[] toByteArray() throws IOException {
        gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.FilterProtos.PolygonFilter.Builder builder =
                gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.FilterProtos.PolygonFilter.newBuilder();
        if (columnFamily != null) {
            builder.setColumnFamily(ByteStringer.wrap(columnFamily));
        }
        if (longitudeColumnQualifier != null) {
            builder.setColumnFamily(ByteStringer.wrap(longitudeColumnQualifier));
        }
        if (latitudeColumnQualifier != null) {
            builder.setColumnFamily(ByteStringer.wrap(latitudeColumnQualifier));
        }
        if (polygon != null) {
            builder.setColumnFamily(ByteStringer.wrap(polygon));
        }
        return builder.build().toByteArray();
    }

    public static Filter parseFrom(byte[] pbBytes) throws DeserializationException {

        gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.FilterProtos.PolygonFilter proto;
        try {
            proto = gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators.customFilters.generated.FilterProtos.PolygonFilter.parseFrom(pbBytes);
        } catch (com.google.protobuf.InvalidProtocolBufferException var6) {
            throw new DeserializationException(var6);
        }

        return new PolygonFilter(proto.getColumnFamily().toByteArray(), proto.getLongitudeColumnQualifier().toByteArray(), proto.getLatitudeColumnQualifier().toByteArray(), proto.getPolygon().toByteArray());

    }
}
