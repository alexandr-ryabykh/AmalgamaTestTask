package api.varieties;

import java.util.ArrayList;

import java.lang.Math;
import java.lang.RuntimeException;

import api.bounds.Bound;
import api.bounds.StrictBound;

public class CompositeVariety implements Variety {
    private ArrayList<Variety> varieties;

    public CompositeVariety(ArrayList<Variety> varieties) {
        this.varieties = varieties;
    }

    public CompositeVariety() {
        this.varieties = new ArrayList();
    }

    public Float closestValueTo(Float number) {
        return this.varieties.stream()
                .map(variety -> variety.closestValueTo(number))
                .sorted((a, b) -> Float.compare(Math.abs(number - a), Math.abs(number - b)))
                .findFirst().get();
    }

    public Variety intersection() {
        return this.varieties.stream()
                .reduce((acc, current) -> acc.intersection(current))
                .orElse(new NullVariety());
    }

    public Variety intersection(Variety variety) {
        return this.varieties.stream()
                .map(internal -> internal.intersection(variety))
                .filter(intersection -> !intersection.isEmpty())
                .filter(intersection -> !intersection.isNull())
                .reduce(new CompositeVariety(), Variety::add);
    }

    public Variety add(Variety variety) {
        this.varieties.add(variety);

        return this;
    }

    public void clear() {
        this.varieties.clear();
    }

    public Bound getLowerBound() {
        throw new RuntimeException();
    }

    public Bound getUpperBound() {
        throw new RuntimeException();
    }

    public boolean isNull() {
        return false;
    }

    public boolean isEmpty() {
        return this.varieties.stream()
                .map(Variety::isEmpty)
                .reduce(true, (acc, current) -> acc && current);
    }

    public String toString() {
        return this.varieties.stream()
                .map(Object::toString)
                .reduce((acc, current) -> acc + " U " + current)
                .orElse("[]");
    }
}
