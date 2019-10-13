package gr.unipi.noda.api.redisearch.filterOperator;

/**
 * @author adimo on 3/10/2019
 * This interface is created to handle the Redis query vs filter commands
 */
public interface RedisFilterOperator {
    StringBuilder getPostOperatorExpression();
}
