package api.helpers;

import api.varieties.Variety;
import api.varieties.LeafVariety;
import api.varieties.EmptyVariety;

import api.bounds.Bound;

public class Intersection {
    private Variety first;
    private Variety other;

    public Intersection(Variety first, Variety other) {
        this.first = first;
        this.other = other;
    }

    public Variety getVariety() {
        return this.noIntersection() ?
                this.emptyIntersection() :
                this.computeIntersection();
    }

    private Variety emptyIntersection() {
        return new EmptyVariety();
    }

    private boolean noIntersection() {
        return this.first.getUpperBound().isLowerThan(this.other.getLowerBound())
                && this.other.getLowerBound().isUpperThan(this.first.getUpperBound())
                || this.first.getLowerBound().isUpperThan(this.other.getUpperBound())
                && this.other.getUpperBound().isLowerThan(this.first.getLowerBound());
    }

    private Variety computeIntersection() {
        return new LeafVariety(this.computeLowerBound(), this.computeUpperBound());
    }

    private Bound computeLowerBound() {
        return this.first.getLowerBound().isLowerThan(this.other.getLowerBound()) ?
                this.other.getLowerBound() :
                this.first.getLowerBound();
    }

    private Bound computeUpperBound() {
        return this.first.getUpperBound().isUpperThan(this.other.getUpperBound()) ?
                this.other.getUpperBound() :
                this.first.getUpperBound();
    }
}
