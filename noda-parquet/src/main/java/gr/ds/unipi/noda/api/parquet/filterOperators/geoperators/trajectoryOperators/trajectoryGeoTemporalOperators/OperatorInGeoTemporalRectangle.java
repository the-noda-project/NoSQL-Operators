package gr.ds.unipi.noda.api.parquet.filterOperators.geoperators.trajectoryOperators.trajectoryGeoTemporalOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geoTemporalOperators.temporal.TemporalBounds;
import gr.ds.unipi.noda.api.core.operators.filterOperators.geoperators.geometries.Rectangle;
import org.apache.parquet.hadoop.ParquetReader;
import org.bson.Document;
import shaded.parquet.com.fasterxml.jackson.core.Base64Variants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperatorInGeoTemporalRectangle extends TrajectoryGeoTemporalOperator<Rectangle, TemporalBounds>{

    private OperatorInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle geometry, TemporalBounds temporalType) {
        super(objectIdField, segmentField, geometry, temporalType);
    }

    @Override
    public Object getOperatorExpression() {
        return null;
    }

    public static OperatorInGeoTemporalRectangle newOperatorInGeoTemporalRectangle(String objectIdField, String segmentField, Rectangle geometry, TemporalBounds temporalType){
        return new OperatorInGeoTemporalRectangle(objectIdField, segmentField, geometry, temporalType);
    }

    public List<Document> refinement(ParquetReader<Document> parquetReader) throws IOException {

        List<Document> documentsList = new ArrayList<>();

        int k =0;
        Document doc = null;
        while ((doc = parquetReader.read() ) != null && k<100){
//                System.out.println(doc.get("segment"));

            Document document = (Document) doc.get("segment");
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
            k++;
        }

        Map<Object, List<Document>> segments = documentsList.stream().collect(Collectors.groupingBy(d-> d.getString("objectId")));

        segments.forEach((key,v)->{

            Comparator<Document> trajsSortByTime = Comparator.comparing(d -> ((List<Long>) ((Document) d.get("segment")).get("timestamps")).get(0));
            v.sort(trajsSortByTime);

//            v.forEach(d->{
//                System.out.println(key+" "+((List<Long>) ((Document) d.get("segment")).get("timestamps")).get(0));
//            });

                for (int i = 0; i < v.size()-1; i++) {
                    int endIndex = ((List<Long>) ((Document) v.get(i).get("segment")).get("timestamps")).size()-1;

                    if(((List<Long>) ((Document) v.get(i).get("segment")).get("timestamps")).get(endIndex).equals(((List<Long>) ((Document) v.get(i+1).get("segment")).get("timestamps")).get(0)) &&
                            ((List<Double>) ((Document) v.get(i).get("segment")).get("longitude")).get(endIndex).equals(((List<Double>) ((Document) v.get(i+1).get("segment")).get("longitude")).get(0)) &&
                            ((List<Double>) ((Document) v.get(i).get("segment")).get("latitude")).get(endIndex).equals(((List<Double>) ((Document) v.get(i+1).get("segment")).get("latitude")).get(0))){
                        System.out.println("CONTINUATION");
                    }
                }


//            System.out.println(key+" "+v.size());
        });

return null;


    }
}
