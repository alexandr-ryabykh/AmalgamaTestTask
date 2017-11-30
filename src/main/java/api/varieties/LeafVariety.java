package api.varieties;

import api.bounds.Bound;
import api.helpers.Intersection;
import api.helpers.ClosestValue;

import java.text.MessageFormat;
import java.lang.RuntimeException;

public class LeafVariety implements Variety {
    private Bound lowerBound;
    private Bound upperBound;

    public LeafVariety(Bound lowerBound, Bound upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Variety intersection(Variety variety) {
        return variety.getClass() == LeafVariety.class ?
                new Intersection(this, variety).getVariety() :
                variety.intersection(this);
    }

    public Float closestValueTo(Float number) {
        return new ClosestValue(this.lowerBound, this.upperBound).to(number);
    }

    public Variety add(Variety variety) {
        throw new RuntimeException();
    }

    public Bound getLowerBound() {
        return this.lowerBound;
    }

    public Bound getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return MessageFormat.format("{0}{1}, {2}{3}", new Object[]{
                this.lowerBound.getLowerChar(),
                this.lowerBound.getValue(),
                this.upperBound.getValue(),
                this.upperBound.getUpperChar()
        });
    }

    public boolean isNull() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }
}
