package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.aggregateOperator.OperatorMax;
import com.github.unipi.trackandknow.nosqldbs.filterOperator.FilterOperator;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBOperators implements NoSqlDbOperators {

    private final MongoCollection mongoCollection;
    private final List<Bson> stagesList;

    private MongoDBOperators(MongoCollection mongoCollection){
        this.mongoCollection = mongoCollection;
        stagesList = new ArrayList<>();
    }

    public static MongoDBOperators newMongoDBOperators(MongoCollection mongoCollection){
        return new MongoDBOperators(mongoCollection);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator) {
        System.out.println(filterOperator.getJsonStringBuilder());
        stagesList.add(Document.parse(" { $match: " + filterOperator.getJsonStringBuilder() + " } "));
        return this;
    }

    @Override
    public void execute(){
        MongoCursor<Document> cursor = mongoCollection.aggregate(stagesList).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }

    @Override
    public int count(){
        stagesList.add(Document.parse("{ $count: \"count\" }"));
        return ((Document) mongoCollection.aggregate(stagesList).first()).getInteger("count",-10);
    }

    @Override
    public double max(String fieldName){

        //System.out.println(Aggregates.match(Filter.parse(FilterOperators.gte("categories", 6).getJsonString())));
        //System.out.println(Aggregates.match(Filters.eq("categories", "Bakery")).toString());

        //stagesList.add(Document.parse(" { $project : {$max: \"id\"} }"));
        //mongoCollection.aggregate(stagesList).first();

        //stagesList.add(Aggregates.project(Document.parse("{$max: \"id\"}")));
        //stagesList.add(new Document("$match", Document.parse(FilterOperators.eq("r",4).getJsonString())));

        //stagesList.add(Document.parse("{ $group: { _id:null, max: { $max: \"$location.coordinates.1\" }} }"));


        stagesList.add(Document.parse("{ $group: { _id:null, "+ OperatorMax.newOperatorMax(fieldName,"max").getJsonStringBuilder() +" } }"));



//        stagesList.add(Document.parse("{ $group: { _id:null, max: { $min: { $arrayElemAt: [ \"$location.coordinates\", 0 ] } }} }"));
//        stagesList.add(Document.parse("{ $project: { dfd: { $min: { $arrayElemAt: [ \"$location.coordinates\", 0 ] } }} }"));

        //System.out.println(Document.parse(" { $project: " + OperatorMax.newOperatorMax(fieldName,"max_"+fieldName).getJsonString() + " } "));
//        stagesList.add(Document.parse(" { $project: " + OperatorMax.newOperatorMax(fieldName,"maxf").getJsonString() + " } "));
//        stagesList.add(Document.parse("{ $count: \"maxf\" }"));
        //System.out.println(((Document) mongoCollection.aggregate(stagesList).first()).getString("maxf"));

        //System.out.println(new Document("$match", FilterOperators.eq("r",4).getJsonString()).toString());


        MongoCursor<Document> cursor = mongoCollection.aggregate(stagesList).iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        System.out.println("dfddffdfd");

        //Aggregates.project()
        //stagesList.add(Document.parse(new Document("$project", AggregateOperators.max(fieldName).getJsonString()).toJson()));

        //System.out.println(new Document("$project", AggregateOperators.max(fieldName).getJsonString()));

        return ((Document) mongoCollection.aggregate(stagesList).first()).getDouble("maxf");
        //return 4;
    }

//    private FilterOperator getFilter(){
//
//        if(filterOperatorList.size()==0){
//            return null;
//        }
//        else if(filterOperatorList.size()==1){
//            return filterOperatorList.get(0);
//        }
//        else{
//            return FilterOperators.and((FilterOperator[]) filterOperatorList.stream().toArray());
//        }
//
//    }

//    @Override
//    public void aggregate(AggregateOperator... aggregateOperator){
//
//        List<Bson> bsonList = new ArrayList<>();
//        FilterOperator fop = getFilter();
//
//        if(fop != null){
//            bsonList.add(Document.parse("{ $match: {" + getFilter().getJsonString() + "} }"));
//        }
//
//        for(AggregateOperator aop : aggregateOperator){
//            bsonList.add(Document.parse(aop.getJsonString()));
//        }
//
//        mongoCollection.aggregate(bsonList);
//
//    }

    @Override
    public NoSqlDbOperators groupBy(String fieldName, AggregateOperator... aggregateOperator){

        StringBuilder sb =  new StringBuilder();

        sb.append("{ $group: { ");



        sb.append("{ _id:");
        sb.append("\"" + "$" + fieldName + "\", ");

        for(AggregateOperator aop : aggregateOperator){
            sb.append(aop.getJsonStringBuilder()+", ");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" }");


        stagesList.add(new Document("$group",sb.toString()));

        return this;
    }

    @Override
    public void project() {
        System.out.println(stagesList.toString());
    }

}
