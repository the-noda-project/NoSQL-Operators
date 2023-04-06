package gr.ds.unipi.noda.api.couchdb;

import com.google.gson.GsonBuilder;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.operators.aggregateOperators.AggregateOperator;
import gr.ds.unipi.noda.api.core.operators.filterOperators.FilterOperator;
import gr.ds.unipi.noda.api.core.operators.joinOperators.JoinOperator;
import gr.ds.unipi.noda.api.core.operators.sortOperators.SortOperator;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

final class CouchDBOperators extends NoSqlDbOperators {

    private final CouchDBConnectionManager couchDBConnectionManager = CouchDBConnectionManager.getInstance();
    private final View.Builder viewBuilder;

    private CouchDBOperators(CouchDBConnector connector, String dataCollection, SparkSession sparkSession) {
        super(connector, dataCollection, sparkSession);
        viewBuilder = new View.Builder(dataCollection);
    }

    private CouchDBOperators(CouchDBOperators self, View.Builder viewBuilder) {
        super(self.getNoSqlDbConnector(), self.getDataCollection(), self.getSparkSession());
        this.viewBuilder = viewBuilder;
    }

    static CouchDBOperators newCouchDBOperators(CouchDBConnector noSqlDbConnector, String dataCollection, SparkSession sparkSession) {
        return new CouchDBOperators(noSqlDbConnector, dataCollection, sparkSession);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators filter(FilterOperator filterOperator, FilterOperator... filterOperators) {
        View.Builder builder = new View.Builder(viewBuilder);

        Stream.concat(Stream.of(filterOperator), Stream.of(filterOperators))
                .map(op -> (String) op.getOperatorExpression())
                .forEach(builder::addFilter);

        return new CouchDBOperators(this, builder);
    }

    @Override
    public CouchDBOperators groupBy(String fieldName, String... fieldNames) {
        View.Builder builder = new View.Builder(viewBuilder);

        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(builder::addGroupField);
        builder.group(true).reduce(true);

        return new CouchDBOperators(this, builder);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators aggregate(AggregateOperator aggregateOperator, AggregateOperator... aggregateOperators) {
        View.Builder builder = new View.Builder(viewBuilder);

        Stream.concat(Stream.of(aggregateOperator), Stream.of(aggregateOperators))
                .forEach(op -> builder.addReduceExpressions(op.getAlias(), (String[]) op.getOperatorExpression())
                        .addValueField(op.getFieldName()));

        builder.reduce(true);

        return new CouchDBOperators(this, builder);
    }

    @Override
    public CouchDBOperators distinct(String fieldName) {
        return groupBy(fieldName);
    }

    @Override
    public void printScreen() {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());
        View.Response response = connection.execute(viewBuilder.build());
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
    }

    @Override
    public Optional<Double> max(String fieldName) {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMax(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        View.Response response = connection.execute(viewBuilder.build());

        if (response.rows.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of((Double) ((Map<String, ?>) response.rows.get(0).value).get(operator.getAlias()));
    }

    @Override
    public Optional<Double> min(String fieldName) {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMin(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        View.Response response = connection.execute(viewBuilder.build());

        if (response.rows.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorSum(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        View.Response response = connection.execute(viewBuilder.build());

        if (response.rows.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorAvg(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        View.Response response = connection.execute(viewBuilder.build());

        if (response.rows.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of((Double) ((Map<String, ?>) response.rows.get(0).value).get(operator.getAlias()));
    }

    @Override
    public int count() {
        CouchDBConnector.CouchDBConnection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        View.Response response = connection.execute(viewBuilder.build());

        if (response.totalRows != null) {
            return response.totalRows;
        } else {
            return response.rows.size();
        }
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators sort(SortOperator sortOperator, SortOperator... sortingOperators) {
        View.Builder builder = new View.Builder(viewBuilder);

        Stream.concat(Stream.of(sortOperator), Stream.of(sortingOperators))
                .map(op -> ((Map) op.getOperatorExpression()))
                .forEach(builder::addSortFields);

        return new CouchDBOperators(this, builder);
    }

    @Override
    public CouchDBOperators limit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must be positive or 0");
        }

        View.Builder builder = new View.Builder(viewBuilder);
        builder.limit(limit);
        return new CouchDBOperators(this, builder);
    }

    @Override
    public CouchDBOperators project(String fieldName, String... fieldNames) {
        View.Builder builder = new View.Builder(viewBuilder);
        Stream.concat(Stream.of(fieldName), Stream.of(fieldNames)).forEach(builder::addProjectField);
        return new CouchDBOperators(this, builder);
    }

    @Override
    public Dataset<Row> toDataframe() {
        return null;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public CouchDBOperators join(NoSqlDbOperators noSqlDbOperators, JoinOperator jo) {
        return null;
    }
}
