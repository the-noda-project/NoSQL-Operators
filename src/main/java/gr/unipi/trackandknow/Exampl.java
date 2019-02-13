package gr.unipi.trackandknow;


import gr.unipi.trackandknow.api.filterOperator.geographicalOperator.Coordinates;

import static gr.unipi.trackandknow.api.filterOperator.FilterOperators.inGeoBox;

import gr.unipi.trackandknow.api.nosqldb.NoSqlDbOperators;

public class Exampl {
        public static void doOperations(NoSqlDbOperators noSqlDbOp) {

            int count = noSqlDbOp.filter(inGeoBox("location",
                    Coordinates.newCoordinates(23.65, 37.94),
                    Coordinates.newCoordinates(23.67, 37.96))).count();

        }
    }
