package api.varieties;

import api.bounds.Bound;

public class EmptyVariety implements Variety {
    public Float closestValueTo(Float number) {
        throw new RuntimeException();
    }

    public Variety intersection(Variety variety) {
        return this;
    }

    public Variety add(Variety variety) {
        return this;
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
        return false;
    }

    public boolean isEmpty() {
        return true;
    }
}
