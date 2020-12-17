package gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators;

import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.BaseTextualOperatorFactory;
import gr.ds.unipi.noda.api.core.operators.filterOperators.textualOperators.conditionalTextualOperators.ConditionalTextualOperator;
import gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.conditionalTextualOperators.OperatorAllKeywords;
import gr.ds.unipi.noda.api.mongo.filterOperators.textualOperators.conditionalTextualOperators.OperatorAnyKeywords;
public final class MongoDBTextualOperatorFactory extends BaseTextualOperatorFactory {

    @Override
    public ConditionalTextualOperator newOperatorAnyKeywords(String fieldName, String keyword, String... keywords) {
        return OperatorAnyKeywords.newOperatorAnyKeywords(fieldName,keyword,keywords);
    }

    @Override
    public ConditionalTextualOperator newOperatorAllKeywords(String fieldName, String keyword1, String keyword2, String... keywords) {
        return OperatorAllKeywords.newOperatorAllKeywords(fieldName,keyword1,keyword2,keywords);
    } 
}
