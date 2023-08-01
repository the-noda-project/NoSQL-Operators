package gr.ds.unipi.noda.api.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetSocketAddress;

public final class CassandraConnector implements NoSqlDbConnector<CqlSession> {

    private final ProgrammaticPlainTextAuthProvider authProvider;
    private final String keyspace;
    private final Inet4Address ipv4;
    private final String datacenter;
    private final String appConfigPath;

    private final int USOLevel;

    private CassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String datacenter, String keyspace, Inet4Address ipv4, String appConfigPath, int USOLevel){
        this.authProvider = authProvider;
        this.datacenter = datacenter;
        this.keyspace = keyspace;
        this.ipv4 = ipv4;
        this.appConfigPath = appConfigPath;
        this.USOLevel = USOLevel;
    }

    public static CassandraConnector newCassandraConnector(ProgrammaticPlainTextAuthProvider authProvider, String datacenter, String keyspace, Inet4Address ipv4, String appConfigPath, int USOLevel){
        return new CassandraConnector(authProvider, datacenter, keyspace, ipv4, appConfigPath,USOLevel);
    }

    @Override
    public CqlSession createConnection() {
        try{
            CqlSession session = null;
            if (!appConfigPath.equals("")){
               session = CqlSession.builder().withConfigLoader(DriverConfigLoader.fromFile(new File(appConfigPath))).build();
            }else{
               session = CqlSession.builder().withAuthProvider(authProvider).withLocalDatacenter(datacenter).withKeyspace(keyspace).addContactPoint(new InetSocketAddress(ipv4, 9042)).build();
            }
            session.execute("DROP TABLE  IF EXISTS filteredTable");
            return session;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    public int getUSOLevel(){
        return USOLevel;
    }
}
