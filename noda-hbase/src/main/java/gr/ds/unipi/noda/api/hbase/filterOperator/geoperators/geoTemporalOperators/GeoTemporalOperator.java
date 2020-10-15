package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.Temporal;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.HBaseGeographicalOperatorFactory;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FuzzyRowFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.Pair;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

abstract class GeoTemporalOperator<T extends Geometry, U extends Temporal> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.GeoTemporalOperator<Filter, T, U> {

    private final FilterList filterList = new FilterList();

    protected GeoTemporalOperator(GeographicalOperator<Filter,T> geographicalOperator, String temporalFieldName, U temporalType) {
        super(geographicalOperator, temporalFieldName, temporalType);
    }

    public Map.Entry<String, byte[]> getMatchingPattern(){

        if(getTemporalType() instanceof TemporalBounds) {

            String geoHashPart = HBaseGeoTemporalOperatorFactory.getGeoHashPart(this.getGeographicalOperator().getGeometry());
            String temporalPart = HBaseGeoTemporalOperatorFactory.getTemporalPart(((TemporalBounds) getTemporalType()).getLowerBound(), ((TemporalBounds) getTemporalType()).getUpperBound());

            byte[] digits = new byte[geoHashPart.length() + 25];

            //geohash
            for (int i = 0; i < geoHashPart.length(); i++) {
                if (geoHashPart.charAt(i) != '?') {
                    digits[i] = 0;
                } else {
                    digits[i] = 1;
                }
            }

            //temporal part
            for (int i = geoHashPart.length() + 1; i < geoHashPart.length() + 1 + temporalPart.length(); i++) {
                if (temporalPart.charAt(i - geoHashPart.length() - 1 ) != '?') {
                    digits[i] = 0;
                } else {
                    digits[i] = 1;
                }
            }

            for (int i = geoHashPart.length() + 1 + temporalPart.length() + 1; i < digits.length; i++) {
                digits[i] = 1;
            }
            digits[geoHashPart.length()] = 0;
            digits[geoHashPart.length() + 1 + temporalPart.length()] = 0;

            return new AbstractMap.SimpleImmutableEntry<>(geoHashPart + "-"+temporalPart+"-??????????", digits);
        }
        else{
            try {
                throw new Exception("Single Temporal Value cannot be handled");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public Filter getOperatorExpression() {

        Map.Entry<String, byte[]> entry = getMatchingPattern();

        List list = Arrays.asList(
                new Pair<>(Bytes.toBytes(entry.getKey()), entry.getValue()
                ));

        filterList.addFilter(new FuzzyRowFilter(list));
        filterList.addFilter(geometryRefactor());

        return filterList;
    }

    abstract protected Filter geometryRefactor();

}
