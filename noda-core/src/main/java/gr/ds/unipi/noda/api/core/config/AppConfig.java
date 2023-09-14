package gr.ds.unipi.noda.api.core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

public class AppConfig {

    private AppConfig() {
    }

    public static Config redis() {
        return ConfigFactory.load()
                .withFallback(ConfigFactory.parseResources("configs/redis.conf")).getConfig("redis");
    }

    public static Config neo4j() {
        return ConfigFactory.load()
                .withFallback(ConfigFactory.parseResources("configs/neo4j.conf")).getConfig("neo4j");
    }

    public static Config mongodb() {
        return ConfigFactory.load()
                .withFallback(ConfigFactory.parseResources("configs/mongodb.conf")).getConfig("mongodb");
    }

    public static Config hbase() {
        return ConfigFactory.load()
                .withFallback(ConfigFactory.parseResources("configs/hbase.conf")).getConfig("hbase");
    }

    public static Config cassandra() {
        return ConfigFactory.load()
                .withFallback(ConfigFactory.parseResources("configs/cassandra.conf")).getConfig("cassandra");
    }
}
