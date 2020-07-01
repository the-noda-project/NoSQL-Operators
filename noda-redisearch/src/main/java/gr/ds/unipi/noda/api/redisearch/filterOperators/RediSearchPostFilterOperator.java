package gr.ds.unipi.noda.api.redisearch.filterOperators;

/**
 * @author adimo on 3/10/2019
 * This interface is created to handle the RediSearch query vs filter commands
 */
public interface RediSearchPostFilterOperator {
    StringBuilder getPostOperatorExpression();
}
