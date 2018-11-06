package com.github.unipi.trackandknow.nosqldbs.mongodb;

import com.github.unipi.trackandknow.nosqldbs.NoSqlDbOperators;
import com.github.unipi.trackandknow.nosqldbs.aggregate.AggregateOperator;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperator;
import com.github.unipi.trackandknow.nosqldbs.filteroperator.FilterOperators;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Filter;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBOperators implements NoSqlDbOperators {

    private final MongoCollection mongoCollection;
    private final List<FilterOperator> filterOperatorList;

    private MongoDBOperators(MongoCollection mongoCollection){
        this.mongoCollection = mongoCollection;
        filterOperatorList = new ArrayList<>();
    }

    public static MongoDBOperators newMongoDBOperators(MongoCollection mongoCollection){
        return new MongoDBOperators(mongoCollection);
    }

    @Override
    public NoSqlDbOperators filter(FilterOperator filterOperator) {
        filterOperatorList.add(filterOperator);
        System.out.println("OK!!!!!!!!!!!!!!!!!!!!!!");
        return this;
    }

    private FilterOperator getFilter(){

        if(filterOperatorList.size()==0){
            return null;
        }
        else if(filterOperatorList.size()==1){
            return filterOperatorList.get(0);
        }
        else{
            return FilterOperators.and((FilterOperator[]) filterOperatorList.stream().toArray());
        }

    }

    @Override
    public void aggregate(AggregateOperator... aggregateOperator){

        List<Bson> bsonList = new ArrayList<>();
        FilterOperator fop = getFilter();

        if(fop != null){
            bsonList.add(Document.parse("{ $match: {" + getFilter().getJsonString() + "} }"));
        }

        for(AggregateOperator aop : aggregateOperator){
            bsonList.add(Document.parse(aop.getJsonString()));
        }

        mongoCollection.aggregate(bsonList);

    }

    @Override
    public void groupBy(String fieldName, AggregateOperator... aggregateOperator){

        List<Bson> bsonList = new ArrayList<>();
        FilterOperator fop = getFilter();

        if(fop != null){
            bsonList.add(Document.parse("{ $match: {" + getFilter().getJsonString() + "} }"));
        }

        StringBuilder sb =  new StringBuilder();
        sb.append("{ $group: { _id:");
        sb.append("\"" + "$" + fieldName + "\", ");

        for(AggregateOperator aop : aggregateOperator){
            sb.append(aop.getJsonString()+", ");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" } }");

        mongoCollection.aggregate(bsonList);
    }

}
