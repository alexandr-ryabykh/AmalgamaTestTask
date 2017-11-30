package api;

import api.varieties.Variety;
import api.varieties.CompositeVariety;

import api.factories.VarietyFactory;

import java.util.ArrayList;
import java.lang.Throwable;

public class TestApi implements Api {
    private CompositeVariety variety;
    private Variety foundIntersection;

    public TestApi() {
        this.variety = new CompositeVariety();
    }

    public void clear() {
        this.foundIntersection = null;
        this.variety.clear();
    }

    public Float closestTo(Float number) {
        try {
            return this.intersection().closestValueTo(number);
        } catch (Throwable e) {
            return null;
        }
    }

    public Variety intersection() {
        if (this.foundIntersection == null) {
            this.foundIntersection = this.variety.intersection();
        }

        return this.foundIntersection;
    }

    public Api variety(String description) {
        this.tryToAddNewVariety(description);

        return this;
    }

    private void tryToAddNewVariety(String description) {
        try {
            this.addNewVariety(description);
        } catch (Throwable e) {
            System.out.println("No new variety.");
        }
    }

    private void addNewVariety(String description) {
        Variety newVariety = VarietyFactory.create(description);

        this.updateIntersection(newVariety);
        this.variety.add(newVariety);
    }

    private void updateIntersection(Variety variety) {
        this.foundIntersection = this.intersection().intersection(variety);
    }
}
