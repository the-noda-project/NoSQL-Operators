package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.github.unipi.trackandknow.nosqldbs.aggregate.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.aggregate.AggregateOperators;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
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
        stagesList.add(new Document("$match",filterOperator.getJsonString()));
        return this;
    }

    @Override
    public double max(String fieldName){

        //stagesList.add(Document.parse("$project : {$max: \"id\"}"));

        stagesList.add(Document.parse(new Document("$project", AggregateOperators.max(fieldName).getJsonString()).toJson()));
        //System.out.println(new Document("$project", AggregateOperators.max(fieldName).getJsonString()));
        return ((Document)   mongoCollection.aggregate(stagesList).first()).getDouble(fieldName);
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
        sb.append("{ _id:");
        sb.append("\"" + "$" + fieldName + "\", ");

        for(AggregateOperator aop : aggregateOperator){
            sb.append(aop.getJsonString()+", ");
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
