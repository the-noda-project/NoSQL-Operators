package gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTextualOperators.geoTextualConstraintOperators;

import java.util.ArrayList;
import java.util.List;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.SmallHilbertCurve;
import org.davidmoten.hilbert.Ranges;
import  gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geographicalOperators.GeographicalOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Geometry;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.Coordinates;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geographicalOperators.HBaseGeographicalOperatorFactory;

import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import java.io.IOException;
import java.text.ParseException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.OrderedBytes;
import org.apache.hadoop.hbase.util.Order;
import org.apache.hadoop.hbase.util.PositionedByteRange;
import org.apache.hadoop.hbase.util.SimplePositionedMutableByteRange;
import gr.ds.unipi.noda.api.hbase.filterOperator.geoperators.geoTextualOperators.*;

public abstract class GeoTextualConstraintOperator<U extends Geometry> extends gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTextualOperators.geoTextualConstraintOperators.GeoTextualConstraintOperator<Filter,U> {

    protected GeoTextualConstraintOperator(GeographicalOperator<Filter, U> geographicalOperator, ConditionalTextualOperator conditionalTextualOperator) {

        super(geographicalOperator, conditionalTextualOperator);
    }
       
    @Override
    public Filter getOperatorExpression() {

    	Coordinates[] coordinates =getGeographicalOperator().getGeometry().getCoordinatesArray();
         double lon1= coordinates[0].getLongitude();
         double lon2= coordinates[2].getLongitude();
         double lat1= coordinates[0].getLatitude();
         double lat2= coordinates[2].getLatitude();
         String columnFamily =getGeographicalOperator().getFieldName();
         
         FilterList hilbertFilters = new FilterList(FilterList.Operator.MUST_PASS_ALL);
         FilterList geoFilters = new FilterList(FilterList.Operator.MUST_PASS_ALL);

         byte[] byteslon1 = new byte[20];
         byte[] byteslat1 = new byte[20];
         byte[] byteslon2 = new byte[20];
         byte[] byteslat2 = new byte[20];

         PositionedByteRange poslon1 = new SimplePositionedMutableByteRange(byteslon1, 0, 20);
         OrderedBytes.encodeNumeric(poslon1,lon1, Order.ASCENDING);
         PositionedByteRange poslat1 = new SimplePositionedMutableByteRange(byteslat1, 0, 20);
         OrderedBytes.encodeNumeric(poslat1, lat1, Order.ASCENDING);
         
         
         PositionedByteRange poslon2 = new SimplePositionedMutableByteRange(byteslon2, 0, 20);
         OrderedBytes.encodeNumeric(poslon2, lon2, Order.ASCENDING);
         PositionedByteRange poslat2 = new SimplePositionedMutableByteRange(byteslat2, 0, 20);
         OrderedBytes.encodeNumeric(poslat2, lat2, Order.ASCENDING);
         String [] keywords=conditionalTextualOperator.getKeywords();

         List<String> hilbertresults= HBaseGeoTextualOperatorFactory.getExpressionOfSpatioTextualHilbertIndexes(getGeographicalOperator().getGeometry().getCoordinatesArray(),keywords);

          
         String joined = String.join("|", hilbertresults);
         hilbertFilters.addFilter(new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes("hilbertindex"), CompareOperator.EQUAL,new RegexStringComparator(joined)));
 	    
         geoFilters.addFilter(new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes("lon"), CompareOperator.GREATER_OR_EQUAL,byteslon1));
         geoFilters.addFilter(new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes("lat"), CompareOperator.LESS_OR_EQUAL,byteslat1));
         geoFilters.addFilter(new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes("lon"), CompareOperator.LESS_OR_EQUAL,byteslon2));
         geoFilters.addFilter(new SingleColumnValueFilter(Bytes.toBytes(columnFamily), Bytes.toBytes("lat"), CompareOperator.GREATER_OR_EQUAL,byteslat2));

         hilbertFilters.addFilter(geoFilters);
         
         return hilbertFilters;
    }

}

