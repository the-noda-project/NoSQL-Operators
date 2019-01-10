package com.github.unipi.trackandknow.nosqldbs.connection;

public abstract class Connector {

    private final Credentials credentials;

    public abstract int hashCode();

    public abstract boolean equals(Object o);

}
