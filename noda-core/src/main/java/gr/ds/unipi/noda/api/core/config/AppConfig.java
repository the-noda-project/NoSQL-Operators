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

//    public static Config setOnRedis(String path, Object value) {
//        return config.getConfig("redis").withValue(path, ConfigValueFactory.fromAnyRef(value));
//    }

}
