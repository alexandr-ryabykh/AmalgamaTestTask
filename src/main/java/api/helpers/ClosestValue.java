package api.helpers;

import java.lang.Math;

import api.bounds.Bound;

public class ClosestValue {
    private Bound lowerBound, upperBound;

    public ClosestValue(Bound lowerBound, Bound upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Float to(Float number) {
        return this.inRangeOfBounds(number) ? number : this.closestBound(number);
    }

    private boolean inRangeOfBounds(Float number) {
        return this.lowerBound.isLowerThan(number) && this.upperBound.isUpperThan(number);
    }

    private Float closestBound(Float number) {
        return this.leftBoundIsCloserTo(number) ?
                this.lowerBound.getValue() :
                this.upperBound.getValue();
    }

    private boolean leftBoundIsCloserTo(Float number) {
        return Math.abs(number - this.lowerBound.getValue()) < Math.abs(number - this.upperBound.getValue());
    }
}
