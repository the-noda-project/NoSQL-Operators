package gr.ds.unipi.noda.api.hbase.filterOperator.geographicalOperators.geoSpatialOperators;

import com.github.davidmoten.geo.GeoHash;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries.Rectangle;
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

        Rectangle mbr = getGeometry().getMbr();

        int length = 8;
        String geoHash = (String) GeoHash.coverBoundingBoxMaxHashes(mbr.getUpperBound().getLatitude(), mbr.getLowerBound().getLongitude(), mbr.getLowerBound().getLatitude(),mbr.getUpperBound().getLongitude(),1).getHashes().toArray()[0];

        if(geoHash.length()>length){
            geoHash = geoHash.substring(0,length);
        }

        geoHash = String.format("%-"+length+"s",geoHash).replace(' ','?');

        byte[] digits = new byte[length+25];

        //geohash
        for(int i =0; i<geoHash.length();i++){
            if(geoHash.charAt(i) != '?'){
                digits[i] = 0;
            }
            else{
                digits[i] = 1;
            }
        }

        for(int i = length; i< digits.length;i++){
            digits[i] = 1;
        }
        digits[length]=0;
        digits[length+13+1] =0;

        List list = Arrays.asList(
                new Pair<>(Bytes.toBytes(geoHash+"-?????????????-??????????"), digits
                ));

        filterList.addFilter(new FuzzyRowFilter(list));
        filterList.addFilter(geometryRefactor());

        return filterList;
    }

    abstract protected Filter geometryRefactor();

}
