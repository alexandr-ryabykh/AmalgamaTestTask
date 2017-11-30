package api.varieties;

import api.bounds.Bound;

public interface Variety {
    public boolean isNull();

    public boolean isEmpty();

    public Float closestValueTo(Float number);

    public Variety intersection(Variety variety);

    public Variety add(Variety variety);

    public Bound getLowerBound();

    public Bound getUpperBound();
}
