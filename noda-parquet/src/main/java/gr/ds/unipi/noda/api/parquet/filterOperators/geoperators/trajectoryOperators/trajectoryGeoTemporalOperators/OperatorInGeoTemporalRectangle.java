package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.hilbert.HilbertUtil;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import org.apache.parquet.filter2.compat.FilterCompat;
import org.apache.parquet.filter2.predicate.FilterApi;
import org.apache.parquet.filter2.predicate.FilterPredicate;
import org.apache.parquet.hadoop.ParquetReader;
import org.bson.Document;
import scala.Tuple3;
import shaded.parquet.com.fasterxml.jackson.core.Base64Variants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.stream.Collectors;

public class OperatorInGeoTemporalRectangle extends TrajectoryGeoTemporalOperator<Rectangle, TemporalBounds>{

    private OperatorInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle geometry, TemporalBounds temporalType) {
        super(objectIdField, segmentField, geometry, temporalType);
    }

    @Override
    public FilterPredicate getOperatorExpression() {
        return FilterApi.and(FilterApi.and(
                FilterApi.and(
                        FilterApi.gtEq(FilterApi.doubleColumn(getSegmentField()+"."+"minLongitude"), getGeometry().getLowerBound().getLongitude()),
                        FilterApi.ltEq(FilterApi.doubleColumn(getSegmentField()+"."+"maxLongitude"), getGeometry().getUpperBound().getLongitude())
                ),
                FilterApi.and(
                        FilterApi.gtEq(FilterApi.doubleColumn(getSegmentField()+"."+"minLatitude"), getGeometry().getLowerBound().getLatitude()),
                        FilterApi.ltEq(FilterApi.doubleColumn(getSegmentField()+"."+"maxLatitude"), getGeometry().getUpperBound().getLatitude())
                )
        ), FilterApi.and(
                FilterApi.gtEq(FilterApi.longColumn(getSegmentField()+"."+"minTimestamp"), getTemporalType().getLowerBound().getTime()),
                FilterApi.ltEq(FilterApi.longColumn(getSegmentField()+"."+"maxTimestamp"), getTemporalType().getUpperBound().getTime())
        ));
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle geometry, TemporalBounds temporalType){
        return new OperatorInGeoTemporalRectangle(objectIdField, segmentField, geometry, temporalType);
    }

    public List<Document> refinement(ParquetReader<Document> parquetReader) throws IOException {

        List<Document> documentsList = new ArrayList<>();

        Document doc = null;
        while ((doc = parquetReader.read() ) != null){

            Document document = (Document) doc.get(getSegmentField());
            byte[] bytesObjectId = Base64Variants.getDefaultVariant().decode(doc.getString("objectId").replaceAll(":","="));
            byte[] bytesLongitude = Base64Variants.getDefaultVariant().decode(document.getString("longitude").replaceAll(":","="));
            byte[] bytesLatitude = Base64Variants.getDefaultVariant().decode(document.getString("latitude").replaceAll(":","="));
            byte[] bytesTimestamps = Base64Variants.getDefaultVariant().decode(document.getString("timestamps").replaceAll(":","="));

            String objectId = new String(bytesObjectId);
            ByteBuffer bbLongitude = ByteBuffer.wrap(bytesLongitude);
            ByteBuffer bbLatitude = ByteBuffer.wrap(bytesLatitude);
            ByteBuffer bbTimestamps = ByteBuffer.wrap(bytesTimestamps);

            int capacity = bbLongitude.capacity()/8;
            List<Double> longitude = new ArrayList<>(capacity);
            List<Double> latitude = new ArrayList<>(capacity);
            List<Long> timestamps = new ArrayList<>(capacity);

            for (int i = 0; i < capacity; i++) {
                longitude.add(bbLongitude.getDouble());
                latitude.add(bbLatitude.getDouble());
                timestamps.add(bbTimestamps.getLong());
            }

            doc.replace("objectId",objectId);
            document.replace("longitude",longitude);
            document.replace("latitude",latitude);
            document.replace("timestamps",timestamps);

            documentsList.add(doc);
        }

        List<Document> trajectoryList = new ArrayList<>();

        documentsList.forEach(document -> {
            List<Double> lon = (List<Double>)((Document)document.get(getSegmentField())).get("longitude");
            List<Double> lat = (List<Double>)((Document)document.get(getSegmentField())).get("latitude");
            List<Long> t = (List<Long>)((Document)document.get(getSegmentField())).get("timestamps");

            List<Tuple3<Double,Double,Long>> currentSpatioTemporalPoints = new ArrayList<>();

            long segment = 1;

//            SpatioTemporalPoint[] spatioTemporalPoints = f.getSpatioTemporalPoints();
            for (int i = 0; i < lon.size() - 1; i++) {

                Optional<Tuple3<Double,Double,Long>[]> stPoints = HilbertUtil.liangBarsky(lon.get(i), lat.get(i),t.get(i),
                        lon.get(i+1), lat.get(i+1),t.get(i+1)
                        ,this.getGeometry().getLowerBound().getLongitude(), this.getGeometry().getLowerBound().getLatitude(), this.getTemporalType().getLowerBound().getTime(), this.getGeometry().getUpperBound().getLongitude(), this.getGeometry().getUpperBound().getLatitude(), this.getTemporalType().getUpperBound().getTime());
                        //,-180, -180, 0, 180, 180, 1900000000000l);

                if(stPoints.isPresent()){
                    if(stPoints.get().length==2){
                        if(stPoints.get()[0]._3() == t.get(i).longValue() &&
                                stPoints.get()[1]._3() == t.get(i+1).longValue()){
                            if(currentSpatioTemporalPoints.size()!=0){
                                if(!currentSpatioTemporalPoints.get(currentSpatioTemporalPoints.size()-1).equals(new Tuple3<>(lon.get(i), lat.get(i), t.get(i)))){
                                    try {
                                        throw new Exception("The i th element of the segment should be the last point of the current list.");
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }

                            if (currentSpatioTemporalPoints.size() == 0) {
                                currentSpatioTemporalPoints.add(new Tuple3(lon.get(i), lat.get(i), t.get(i)));
                            }
                            currentSpatioTemporalPoints.add(new Tuple3(lon.get(i+1), lat.get(i+1), t.get(i+1)));

                        }else if(stPoints.get()[0]._3() == t.get(i).longValue()){
                            if (currentSpatioTemporalPoints.size() == 0) {
                                currentSpatioTemporalPoints.add(new Tuple3(lon.get(i), lat.get(i), t.get(i)));
                            }
                            currentSpatioTemporalPoints.add(new Tuple3(stPoints.get()[1]._1(), stPoints.get()[1]._2(), stPoints.get()[1]._3()));
                            trajectoryList.add( formDocument(new Document(document), currentSpatioTemporalPoints, segment));
                            currentSpatioTemporalPoints.clear();
                        }else if(stPoints.get()[1]._3() == t.get(i+1).longValue()){
                            if(currentSpatioTemporalPoints.size()==1){
                                try {
                                    throw new Exception("Exception for the current list, it will be flushed and has only one element.");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }

                            if (currentSpatioTemporalPoints.size() != 0) {
                                trajectoryList.add( formDocument(new Document(document), currentSpatioTemporalPoints, segment));
                                currentSpatioTemporalPoints.clear();
                            }
                            currentSpatioTemporalPoints.add(new Tuple3(stPoints.get()[0]._1(), stPoints.get()[0]._2(), stPoints.get()[0]._3()));
                            currentSpatioTemporalPoints.add(new Tuple3(lon.get(i+1), lat.get(i+1), t.get(i+1)));
                        }else{
                            if(currentSpatioTemporalPoints.size()!=0){
                                try {
                                    throw new Exception("The current list has elements while it should not have.");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            currentSpatioTemporalPoints.add(new Tuple3(stPoints.get()[0]._1(), stPoints.get()[0]._2(), stPoints.get()[0]._3()));
                            currentSpatioTemporalPoints.add(new Tuple3(stPoints.get()[1]._1(), stPoints.get()[1]._2(), stPoints.get()[1]._3()));
                            trajectoryList.add( formDocument(new Document(document), currentSpatioTemporalPoints, segment));
                            currentSpatioTemporalPoints.clear();
                        }
                    }else{
                        try {
                            throw new Exception("The array from the Liang Barsky should contain at least one element");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }else{
                    if (currentSpatioTemporalPoints.size() > 0) {
                        trajectoryList.add( formDocument(new Document(document), currentSpatioTemporalPoints, segment));
                        currentSpatioTemporalPoints.clear();
                    }
                }
            }
            if (currentSpatioTemporalPoints.size() > 0) {
                trajectoryList.add( formDocument(new Document(document), currentSpatioTemporalPoints, segment));
                currentSpatioTemporalPoints.clear();
            }
        });


        List<Document> concatenatedSegments = new ArrayList<>();

        Map<Object, List<Document>> segments = trajectoryList.stream().collect(Collectors.groupingBy(d-> d.getString("objectId")));

        segments.forEach((key,v)->{

            Comparator<Document> trajsSortByTime = Comparator.comparing(d -> ((List<Long>) ((Document) d.get(getSegmentField())).get("timestamps")).get(0));
            v.sort(trajsSortByTime);

            int num = 1;
            Document document =  v.get(0);
            Document segmentDocument = (Document) document.get(getSegmentField());

            List<Double> longitude = new ArrayList<>();
            List<Double> latitude = new ArrayList<>();
            List<Long> timestamps = new ArrayList<>();

            longitude.addAll((List<Double>) ((Document) v.get(0).get(getSegmentField())).get("longitude"));
            latitude.addAll((List<Double>) ((Document) v.get(0).get(getSegmentField())).get("latitude"));
            timestamps.addAll((List<Long>) ((Document) v.get(0).get(getSegmentField())).get("timestamps"));

            for (int i = 0; i < v.size()-1; i++) {
                    int endIndex = ((List<Long>) ((Document) v.get(i).get(getSegmentField())).get("timestamps")).size()-1;

                    if(((List<Long>) ((Document) v.get(i).get(getSegmentField())).get("timestamps")).get(endIndex).equals(((List<Long>) ((Document) v.get(i+1).get(getSegmentField())).get("timestamps")).get(0)) &&
                            ((List<Double>) ((Document) v.get(i).get(getSegmentField())).get("longitude")).get(endIndex).equals(((List<Double>) ((Document) v.get(i+1).get(getSegmentField())).get("longitude")).get(0)) &&
                            ((List<Double>) ((Document) v.get(i).get(getSegmentField())).get("latitude")).get(endIndex).equals(((List<Double>) ((Document) v.get(i+1).get(getSegmentField())).get("latitude")).get(0))){

                        for (int i1 = 1; i1 < ((List<Double>) ((Document) v.get(i + 1).get(getSegmentField())).get("longitude")).size(); i1++) {
                            longitude.add(((List<Double>) ((Document) v.get(i + 1).get(getSegmentField())).get("longitude")).get(i1));
                        }

                        for (int i1 = 1; i1 < ((List<Double>) ((Document) v.get(i + 1).get(getSegmentField())).get("latitude")).size(); i1++) {
                            latitude.add(((List<Double>) ((Document) v.get(i + 1).get(getSegmentField())).get("latitude")).get(i1));

                        }
                        for (int i1 = 1; i1 < ((List<Long>) ((Document) v.get(i + 1).get(getSegmentField())).get("timestamps")).size(); i1++) {
                            timestamps.add(((List<Long>) ((Document) v.get(i + 1).get(getSegmentField())).get("timestamps")).get(i1));
                        }
                    }else{

                        segmentDocument.replace("num",num++);
                        segmentDocument.replace("longitude",longitude);
                        segmentDocument.replace("latitude",latitude);
                        segmentDocument.replace("timestamps",timestamps);

                        concatenatedSegments.add(document);

                        longitude.clear();
                        latitude.clear();
                        timestamps.clear();

                        longitude.addAll((List<Double>) ((Document) v.get(i+1).get(getSegmentField())).get("longitude"));
                        latitude.addAll((List<Double>) ((Document) v.get(i+1).get(getSegmentField())).get("latitude"));
                        timestamps.addAll((List<Long>) ((Document) v.get(i+1).get(getSegmentField())).get("timestamps"));
                    }
                }

            if(!longitude.isEmpty()){

                segmentDocument.replace("num",num++);
                segmentDocument.replace("longitude",longitude);
                segmentDocument.replace("latitude",latitude);
                segmentDocument.replace("timestamps",timestamps);
                concatenatedSegments.add(document);

            }
        });

        System.out.println(trajectoryList.size()+ " "+ concatenatedSegments.size()+ " "+segments.size());
        segments.clear();
        trajectoryList.clear();

        return concatenatedSegments;
    }

    private Document formDocument(Document doc, List<Tuple3<Double,Double,Long>> spatiotemporalPoints, long num){
        Document document = (Document) doc.get(getSegmentField());

        List<Double> longitude = new ArrayList<>(spatiotemporalPoints.size());
        List<Double> latitude = new ArrayList<>(spatiotemporalPoints.size());
        List<Long> timestamps = new ArrayList<>(spatiotemporalPoints.size());

        for (Tuple3<Double, Double, Long> spatiotemporalPoint : spatiotemporalPoints) {
            longitude.add(spatiotemporalPoint._1());
            latitude.add(spatiotemporalPoint._2());
            timestamps.add(spatiotemporalPoint._3());
        }

        document.replace("num",num);
        document.replace("longitude",longitude);
        document.replace("latitude",latitude);
        document.replace("timestamps",timestamps);
        return doc;
    }
}
