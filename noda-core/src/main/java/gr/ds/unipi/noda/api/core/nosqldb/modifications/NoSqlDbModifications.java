package gr.ds.unipi.noda.api.core.nosqldb.modifications;

import gr.ds.unipi.noda.api.core.nosqldb.NoSqlDbConnector;

abstract class NoSqlDbModifications{

    private final NoSqlDbConnector noSqlDbConnector;
    private final String dataCollection;

    protected NoSqlDbModifications(NoSqlDbConnector noSqlDbConnector, String dataCollection) {
        this.noSqlDbConnector = noSqlDbConnector;
        this.dataCollection = dataCollection;
    }

    public abstract <T extends NoSqlDbModifications> T flush();

    protected NoSqlDbConnector getNoSqlDbConnector() {
        return noSqlDbConnector;
    }

    protected String getDataCollection() {
        return dataCollection;
    }
}
