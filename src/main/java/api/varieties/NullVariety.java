package api.varieties;

import api.bounds.Bound;

public class NullVariety implements Variety {
    public Float closestValueTo(Float number) {
        throw new RuntimeException();
    }

    public Variety intersection(Variety variety) {
        return variety;
    }

    public Variety add(Variety variety) {
        throw new RuntimeException();
    }

    public Bound getLowerBound() {
        throw new RuntimeException();
    }

    public Bound getUpperBound() {
        throw new RuntimeException();
    }

    public String toString() {
        return "[]";
    }

    public boolean isNull() {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }
}