package gr.ds.unipi.noda.api.client.hbase;

import gr.ds.unipi.noda.api.client.NoSqlDbSys;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import gr.ds.unipi.noda.api.hbase.HBaseConnectionFactory;
import gr.ds.unipi.noda.api.hbase.HBaseConnector;
import javafx.util.Pair;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

public class HBaseSys extends NoSqlDbSys {

    private final HBaseConnector connector;

    @Override
    protected NoSqlDbConnector getConnector() {
        return connector;
    }

    public static class Builder extends NoSqlDbSys.Builder<Builder>{

        private Configuration config = HBaseConfiguration.create();

        public Builder(){

        }

        public Builder addProperty(String name, String value){
            config.set(name, value);
            return this;
        }

        public Builder configuration(Configuration config){
            this.config.addResource(config);
            return this;
        }

        @Override
        public NoSqlDbSys build() {
            return new HBaseSys(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private HBaseSys(Builder builder) {
        super(builder, new HBaseConnectionFactory());

        StringBuilder sb = new StringBuilder();
        for(Pair<String,Integer> pair : getAddresses()){
            sb.append(pair.getKey()).append(":").append(pair.getValue()).append(",");
        }

        sb.deleteCharAt(sb.lastIndexOf(","));

        builder.config.set("hbase.zookeeper.quorum",sb.toString());

        connector = HBaseConnector.newHBaseConnector(builder.config);
    }

}
