package gr.ds.unipi.noda.api.core.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValueFactory;

public class AppConfig {

    private static final Config config = ConfigFactory.load()
            .withFallback(ConfigFactory.parseResources("configs/redis.conf"));

    private AppConfig(){
    }

    public static Config redis(){
        return config.getConfig("redis");
    }

    public static Config setOnRedis(String path, Object value){
        return config.getConfig("redis").withValue(path, ConfigValueFactory.fromAnyRef(value));
    }

}
