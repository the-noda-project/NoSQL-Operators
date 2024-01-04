package gr.ds.unipi.noda.api.client;

import gr.ds.unipi.noda.api.client.cassandra.CassandraBuilderFactory;
import gr.ds.unipi.noda.api.client.couchdb.CouchDBBuilderFactory;
import gr.ds.unipi.noda.api.client.hbase.HBaseBuilderFactory;
import gr.ds.unipi.noda.api.client.mongo.MongoDBBuilderFactory;
import gr.ds.unipi.noda.api.client.neo4j.Neo4jBuilderFactory;
import gr.ds.unipi.noda.api.client.parquet.ParquetBuilderFactory;
import gr.ds.unipi.noda.api.client.redis.RedisBuilderFactory;
import gr.ds.unipi.noda.api.client.redisearch.RediSearchBuilderFactory;
import gr.ds.unipi.noda.api.client.sql.*;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlConnectionFactory;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbOperators;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbDeletes;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbInserts;
import gr.ds.unipi.noda.api.core.nosqldb.modifications.NoSqlDbUpdates;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.spark.sql.SparkSession;

import java.util.*;
import java.util.stream.Collectors;

public abstract class NoSqlDbSystem {

    private final List<Map.Entry<String, Integer>> addresses;
    private final SparkSession sparkSession;
    private final NoSqlConnectionFactory nsdb;

    protected abstract static class Builder<T extends Builder<T>> {

        List<Map.Entry<String, Integer>> addresses = new ArrayList<>();
        SparkSession sparkSession = null;

        public T host(String host) {
            int i = 0;
            while (i < addresses.size()) {
                if (addresses.get(i).getKey() == null) {
                    addresses.set(i, new AbstractMap.SimpleImmutableEntry<>(host, addresses.get(i).getValue()));
                    break;
                }
                i++;
            }
            if (i == addresses.size()) {
                addresses.add(new AbstractMap.SimpleImmutableEntry<>(host, null));
            }

            return self();
        }

        public T port(int port) {
            int i = 0;
            while (i < addresses.size()) {
                if (addresses.get(i).getValue() == null) {
                    addresses.set(i, new AbstractMap.SimpleImmutableEntry<>(addresses.get(i).getKey(), port));
                    break;
                }
                i++;
            }
            if (i == addresses.size()) {
                addresses.add(new AbstractMap.SimpleImmutableEntry<>(null, port));
            }
            return self();
        }

        public T sparkSession(SparkSession sparkSession) {
            this.sparkSession = sparkSession;
            return self();
        }

        protected abstract NoSqlDbSystem build();

        protected abstract T self();
    }

    protected NoSqlDbSystem(Builder<?> builder, NoSqlConnectionFactory noSqlConnectionFactory) {
        sparkSession = builder.sparkSession;
        nsdb = noSqlConnectionFactory;

        for (int i = 0; i < builder.addresses.size(); i++) {
            if (builder.addresses.get(i).getKey() == null) {
                builder.addresses.set(i, new AbstractMap.SimpleImmutableEntry<>(getDefaultHost(), builder.addresses.get(i).getValue()));
            }
            if (builder.addresses.get(i).getValue() == null) {
                builder.addresses.set(i, new AbstractMap.SimpleImmutableEntry<>(builder.addresses.get(i).getKey(), getDefaultPort()));
            }
        }

        if (builder.addresses.size() == 0) {
            builder.addresses.add(new AbstractMap.SimpleImmutableEntry<>(getDefaultHost(), getDefaultPort()));
        }

        addresses = Collections.unmodifiableList(builder.addresses.stream().distinct().collect(Collectors.toList()));//list is sorted
    }

    protected List<Map.Entry<String, Integer>> getAddresses() {
        return addresses;
    }

    protected abstract NoSqlDbConnector getConnector();

    public NoSqlDbSqlStatement sql(String sql){

        CharStream s = CharStreams.fromString(sql);
        CaseChangingCharStream upper = new CaseChangingCharStream(s,true);
        SqlBaseLexer lexer =  new SqlBaseLexer(upper);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);

        ParseTree tree = parser.singleStatement();
        ParseTreeWalker walker = new ParseTreeWalker();

        NoSqlDbSqlStatementListener listener = NoSqlDbSqlStatementListener.newNodaSqlListener();
        walker.walk(listener,tree);

        listener.setNoSqlDbOperators(nsdb.noSqlDbOperators(getConnector(), listener.getSource(), sparkSession));
        return NoSqlDbSqlStatement.newNodaSqlOperators(listener.getNoSqlDbOperators());

    }

    public NoSqlDbOperators operateOn(String s) {
        return nsdb.noSqlDbOperators(getConnector(), s, sparkSession);
    }

    public NoSqlDbInserts insertionsOn(String s) {
        return nsdb.noSqlDbInserts(getConnector(), s);
    }

    public NoSqlDbDeletes deletionsOn(String s) {
        return nsdb.noSqlDbDeletes(getConnector(), s);
    }

    public NoSqlDbUpdates updatesOn(String s) {
        return nsdb.noSqlDbUpdates(getConnector(), s);
    }

    public void closeConnection() {
        nsdb.closeConnection(getConnector());
    }

    public static void closeConnections() {
        toBeCleaned.forEach(NoSqlConnectionFactory::closeConnections);
    }

    private static final List<NoSqlConnectionFactory> toBeCleaned = new ArrayList<>();

    public static MongoDBBuilderFactory MongoDB() {
        return new MongoDBBuilderFactory();
    }

    public static Neo4jBuilderFactory Neo4j() {
        return new Neo4jBuilderFactory();
    }

    public static HBaseBuilderFactory HBase() {
        return new HBaseBuilderFactory();
    }

    public static RediSearchBuilderFactory RediSearch() {
        return new RediSearchBuilderFactory();
    }

    public static RedisBuilderFactory Redis() {
        return new RedisBuilderFactory();
    }

    public static CouchDBBuilderFactory CouchDB() {
        return new CouchDBBuilderFactory();
    }

    public static CassandraBuilderFactory Cassandra() {
        return new CassandraBuilderFactory();
    }

    public static ParquetBuilderFactory Parquet() {
        return new ParquetBuilderFactory();
    }

    public String getDefaultHost() {
        return "localhost";
    }

    public abstract int getDefaultPort();

}
