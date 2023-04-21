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

import javax.annotation.Nullable;
import java.io.IOException;
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
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            View.Response response = connection.execute(viewBuilder.build());
            System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Double> max(String fieldName) {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMax(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return response.rows.isEmpty() ? Optional.empty()
                                           : Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Double> min(String fieldName) {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorMin(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return response.rows.isEmpty() ? Optional.empty()
                                           : Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Double> sum(String fieldName) {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorSum(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return response.rows.isEmpty() ? Optional.empty()
                                           : Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<Double> avg(String fieldName) {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        AggregateOperator<?> operator = AggregateOperator.aggregateOperator.newOperatorAvg(fieldName);

        viewBuilder.addReduceExpressions(operator.getAlias(), (String[]) operator.getOperatorExpression())
                .addValueField(fieldName)
                .reduce(true)
                .group(false);

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return response.rows.isEmpty() ? Optional.empty()
                                           : Optional.of((Double) response.rows.get(0).value.get(operator.getAlias()));
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public int count() {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return response.totalRows != null ? response.totalRows : response.rows.size();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
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
            throw new IllegalArgumentException("Limit must be a positive number");
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

    @Override
    @Nullable
    public CouchDBResults getResults() {
        CouchDBConnector.Connection connection = couchDBConnectionManager.getConnection(getNoSqlDbConnector());

        try {
            View.Response response = connection.execute(viewBuilder.build());
            return new CouchDBResults(response.rows.iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
