package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import gr.ds.unipi.noda.api.couchdb.filterOperators.FilterStrategy;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.stream.Stream;

final class CouchDBOperators extends NoSqlDbOperators {

    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final Query query;

    private CouchDBOperators(CouchDBConnector connector, String dataCollection, SparkSession sparkSession) {
        super(connector, dataCollection, sparkSession);
        query = new Query();
    }

    private CouchDBOperators(CouchDBOperators self, Query query) {
        super(self.getNoSqlDbConnector(), self.getDataCollection(), self.getSparkSession());
        this.query = query;
    }

    static CouchDBOperators newCouchDBOperators(CouchDBConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        return new CouchDBOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    public CouchDBOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        Query query = new Query(this.query);
        Stream.concat(Stream.of(filterOperator), Stream.of(filterOperators))
                .forEach(op -> query.addFilter((FilterStrategy) op.getOperatorExpression()));
        return new CouchDBOperators(this, query);
    }

    @Override
    public CouchDBOperators groupBy(String fieldName, String... fieldNames) {
        Query query = new Query(this.query);

        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(query::addGroupField);
        query.setGroup(true);
        query.setReduce(true);

        return new CouchDBOperators(this, query);
    }

    @Override
    public CouchDBOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        Query query = new Query(this.query);

        Stream.concat(Stream.of(aggregateOperator), Stream.of(aggregateOperators)).forEach(op -> {
            query.addAggregate(op.getAlias(), (ImmutablePair<String, String>) op.getOperatorExpression());
            query.addValueField(op.getFieldName());
        });
        query.setReduce(true);

        return new CouchDBOperators(this, query);
    }

    @Override
    public CouchDBOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            Connection.AbstractResponse response = connection.runQuery(getDataCollection(), query);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMax(fieldName);

        query.addAggregate(operator.getAlias(), (ImmutablePair<String, String>) operator.getOperatorExpression());
        query.addValueField(fieldName);
        query.setReduce(true);
        query.setGroup(false);

        try {
            Connection.ViewResponse response = (Connection.ViewResponse) connection.runQuery(
                    getDataCollection(),
                    query
            );
            if (response != null && !response.rows.isEmpty()) {
                return Optional.of(response.rows.get(0).value.getAsJsonObject().get(operator.getAlias()).getAsDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Double> min(String fieldName) {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMin(fieldName);

        query.addAggregate(operator.getAlias(), (ImmutablePair<String, String>) operator.getOperatorExpression());
        query.addValueField(fieldName);
        query.setReduce(true);
        query.setGroup(false);

        try {
            Connection.ViewResponse response = (Connection.ViewResponse) connection.runQuery(
                    getDataCollection(),
                    query
            );
            if (response != null && !response.rows.isEmpty()) {
                return Optional.of(response.rows.get(0).value.getAsJsonObject().get(operator.getAlias()).getAsDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorSum(fieldName);

        query.addAggregate(operator.getAlias(), (ImmutablePair<String, String>) operator.getOperatorExpression());
        query.addValueField(fieldName);
        query.setReduce(true);
        query.setGroup(false);

        try {
            Connection.ViewResponse response = (Connection.ViewResponse) connection.runQuery(
                    getDataCollection(),
                    query
            );
            if (response != null && !response.rows.isEmpty()) {
                return Optional.of(response.rows.get(0).value.getAsJsonObject().get(operator.getAlias()).getAsDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorAvg(fieldName);

        query.addAggregate(operator.getAlias(), (ImmutablePair<String, String>) operator.getOperatorExpression());
        query.addValueField(fieldName);
        query.setReduce(true);
        query.setGroup(false);

        try {
            Connection.ViewResponse response = (Connection.ViewResponse) connection.runQuery(
                    getDataCollection(),
                    query
            );
            if (response != null && !response.rows.isEmpty()) {
                return Optional.of(response.rows.get(0).value.getAsJsonObject().get(operator.getAlias()).getAsDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public int count() {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            Connection.AbstractResponse response = connection.runQuery(getDataCollection(), query);
            if (response != null) {
                return response.getTotalRows();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public CouchDBOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        Query query = new Query(this.query);

        Stream.concat(Stream.of(sortOperator), Stream.of(sortingOperators))
                .map(op -> (ImmutablePair<?, ?>) op.getOperatorExpression())
                .forEach(op -> query.addSortField((ImmutablePair<String, String>) op));

        return new CouchDBOperators(this, query);
    }

    @Override
    public CouchDBOperators limit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit must be a positive number.");
        }

        Query query = new Query(this.query);
        query.setLimit(limit);

        return new CouchDBOperators(this, query);
    }

    @Override
    public CouchDBOperators project(String fieldName, String... fieldNames) {
        Query query = new Query(this.query);
        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(query::addProjectField);
        return new CouchDBOperators(this, query);
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

    @Override
    public CouchDBOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        throw new UnsupportedOperationException("The join operation is not supported in CouchDB");
    }

    @Override
    @Nullable
    public CouchDBResults getResults() {
        Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            Connection.AbstractResponse response = connection.runQuery(getDataCollection(), query);

            if (response instanceof Connection.ViewResponse) {
                Stream<JsonObject> docsStream;
                if (query.isReduce()) {
                    docsStream = ((Connection.ViewResponse) response).rows.stream().map(row -> {
                        JsonObject newRow = new JsonObject();
                        newRow.add(row.key.toString(), row.value);
                        return newRow;
                    });
                } else {
                    docsStream = ((Connection.ViewResponse) response).rows.stream().map(row -> row.doc);
                }

                return new CouchDBResults(docsStream.iterator());
            } else if (response instanceof Connection.FindResponse) {
                return new CouchDBResults(((Connection.FindResponse) response).docs.iterator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
