package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import javafx.util.Pair;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FuzzyRowFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Arrays;
import java.util.List;

abstract class GeoSpatialOperator<T extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geoSpatialOperators.GeoSpatialOperator<Filter, T> {
    protected GeoSpatialOperator(String fieldName, T geometry) {
        super(fieldName, geometry);
    }

    private final FilterList filterList = new FilterList();

    @Override
    public Filter getOperatorExpression() {

        getGeometry().getMbr();//code to be written

        List list = Arrays.asList(
                new Pair<>(Bytes.toBytes("row-?5"), new byte[]{0, 0, 0, 0, 1, 0}
                ));

        filterList.addFilter(new FuzzyRowFilter(list));
        filterList.addFilter(geometryRefactor());

        return filterList;
    }

    abstract protected Filter geometryRefactor();


}
