package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.stream.Stream;

final class CouchDBOperators extends NoSqlDbOperators {

    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final ViewQuery viewQuery;

    private CouchDBOperators(CouchDBConnector connector, String dataCollection, SparkSession sparkSession) {
        super(connector, dataCollection, sparkSession);
        viewQuery = new ViewQuery();
    }

    private CouchDBOperators(CouchDBOperators self, ViewQuery viewQuery) {
        super(self.getNoSqlDbConnector(), self.getDataCollection(), self.getSparkSession());
        this.viewQuery = viewQuery;
    }

    static CouchDBOperators newCouchDBOperators(CouchDBConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        return new CouchDBOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        ViewQuery viewQuery = new ViewQuery(this.viewQuery);
        Stream.concat(Stream.of(filterOperator), Stream.of(filterOperators)).forEach(viewQuery::addFilter);
        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    public CouchDBOperators groupBy(String fieldName, String... fieldNames) {
        ViewQuery viewQuery = new ViewQuery(this.viewQuery);

        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(viewQuery::addGroupField);
        viewQuery.setGroup(true);
        viewQuery.setReduce(true);

        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        ViewQuery viewQuery = new ViewQuery(this.viewQuery);

        Stream.concat(Stream.of(aggregateOperator), Stream.of(aggregateOperators)).forEach(op -> {
            viewQuery.addAggregate(op);
            viewQuery.addValueField(op.getFieldName());
        });
        viewQuery.setReduce(true);

        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    public CouchDBOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMax(fieldName);

        viewQuery.addAggregate(operator);
        viewQuery.addValueField(fieldName);
        viewQuery.setReduce(true);
        viewQuery.setGroup(false);

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
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
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMin(fieldName);

        viewQuery.addAggregate(operator);
        viewQuery.addValueField(fieldName);
        viewQuery.setReduce(true);
        viewQuery.setGroup(false);

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
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
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorSum(fieldName);

        viewQuery.addAggregate(operator);
        viewQuery.addValueField(fieldName);
        viewQuery.setReduce(true);
        viewQuery.setGroup(false);

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
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
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorAvg(fieldName);

        viewQuery.addAggregate(operator);
        viewQuery.addValueField(fieldName);
        viewQuery.setReduce(true);
        viewQuery.setGroup(false);

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
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
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
            if (response != null) {
                return response.totalRows != null ? response.totalRows : response.rows.size();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        ViewQuery viewQuery = new ViewQuery(this.viewQuery);

        Stream.concat(Stream.of(sortOperator), Stream.of(sortingOperators))
                .map(op -> (ImmutablePair<?, ?>) op.getOperatorExpression())
                .forEach(op -> viewQuery.addSortField((String) op.getLeft(), (String) op.getRight()));

        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    public CouchDBOperators limit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit must be a positive number.");
        }

        ViewQuery viewQuery = new ViewQuery(this.viewQuery);
        viewQuery.setLimit(limit);

        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    public CouchDBOperators project(String fieldName, String... fieldNames) {
        ViewQuery viewQuery = new ViewQuery(this.viewQuery);
        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(viewQuery::addProjectField);
        return new CouchDBOperators(this, viewQuery);
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        throw new UnsupportedOperationException("The join operation is not supported in CouchDB");
    }

    @Override
    @Nullable
    public CouchDBResults getResults() {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            ViewResponse response = connection.runQuery(getDataCollection(), viewQuery);
            if (response != null) {
                return new CouchDBResults(response.rows.stream().map(r -> {
                    if (r.doc != null) {
                        return r.doc;
                    }

                    if (r.value != null) {
                        JsonObject value = new JsonObject();
                        value.add(r.key.toString(), r.value);
                        return value;
                    }

                    return null;
                }).iterator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
