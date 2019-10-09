package gr.unipi.noda.api.client;

import static gr.unipi.noda.api.core.operators.AggregateOperators.max;

public class TestClass {
    public static void main(String[] args) {
        NoSqlDbSystem.MongoDB().build().operateOn("coll1").groupBy("", max(""));

    }
}
