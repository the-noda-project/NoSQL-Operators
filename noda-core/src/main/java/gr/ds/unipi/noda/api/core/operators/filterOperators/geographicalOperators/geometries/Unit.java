package gr.ds.unipi.noda.api.core.operators.filterOperators.geographicalOperators.geometries;

public enum Unit {
    M(1),
    KM(1000),
    MI(1609.344),
    FT(3.280839895);
    public double metersEquivalent;

    Unit(double i) {
        this.metersEquivalent = i;
    }
}
