package gr.ds.unipi.noda.api.client.redisearch;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnectionFactory;
import gr.ds.unipi.noda.api.redisearch.RediSearchConnector;
import gr.ds.unipi.noda.api.redisearch.RediSearchOptions;
import javafx.util.Pair;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.util.Pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RediSearchSys extends NoSqlDbSys {

    private final RediSearchConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{
        private Pool<Jedis> jedisPool;
        private RediSearchOptions rediSearchOptions;
        List<Pair<String,Integer>> sentinels = new ArrayList<>();


        public Builder(){
        }

        public Builder options(int timeout, int poolSize, String password){
            this.rediSearchOptions = RediSearchOptions.createCredential(poolSize, timeout, password);
            this.jedisPool = null;
            return this;
        }

        public Builder options(String master, Set<String> sentinels, int timeout, int poolSize, String password) {
            this.rediSearchOptions = RediSearchOptions.createCredential(master, sentinels, poolSize, timeout, password);
            this.jedisPool = null;
            return this;
        }

        public Builder sentinelHost(String host){

            int i = 0;
            while(i<sentinels.size()){
                if(sentinels.get(i).getKey() == null){
                    sentinels.set(i,new Pair<>(host, sentinels.get(i).getValue()));
                    break;
                }
                i++;
            }
            if(i == sentinels.size()){
                sentinels.add(new Pair<>(host,null));
            }

            return this;
        }

        public Builder sentinelPort(int port){

            int i = 0;
            while(i<sentinels.size()){
                if(sentinels.get(i).getValue() == null){
                    sentinels.set(i,new Pair<>(sentinels.get(i).getKey(), port));
                    break;
                }
                i++;
            }
            if(i == sentinels.size()){
                sentinels.add(new Pair<>(null,port));
            }
            return this;
        }



        public Builder(Pool<Jedis> jedisPool) {
            this.rediSearchOptions = null;
            this.jedisPool = jedisPool;
        }

        @Override
        public NoSqlDbSys build() {
            return new RediSearchSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private RediSearchSys(Builder builder) {
        super(builder, new RediSearchConnectionFactory());

        for(int i=0;i<builder.sentinels.size();i++){
            if(builder.sentinels.get(i).getKey()==null){
                builder.sentinels.set(i,new Pair<>("DEFAULT_HOST_OF_SENTINEL",builder.sentinels.get(i).getValue()));
            }
            if(builder.sentinels.get(i).getValue()==null){
                builder.sentinels.set(i,new Pair<>(builder.sentinels.get(i).getKey(),"DEFAULT_PORT_OF_SENTINEL_INTEGER"));
            }
        }

        if(getAddresses().size()==0){
            builder.sentinels.add(new Pair<>("DEFAULT_HOST_OF_SENTINEL","DEFAULT_PORT_OF_SENTINEL_INTEGER"));
        }

        //auti i ekfrasi einai gia na tin peraseis ston connector kai na pareis ta sentinels
        Collections.unmodifiableList(builder.sentinels.stream().distinct().collect(Collectors.toList()));
        //ean yparxoyn sentinels tote to size tis listas tha einai 0 alliws ean yparxoyn tote >0




        connector = RediSearchConnector.newRediSearchConnector(getAddresses(), builder.rediSearchOptions, builder.jedisPool);
    }
}
