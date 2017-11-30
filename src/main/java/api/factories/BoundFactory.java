package api.factories;

import api.bounds.Bound;
import api.bounds.StrictBound;
import api.bounds.SoftBound;

import api.patterns.BoundsPattern;

public class BoundFactory {
    public static Bound[] create(String description) {
        BoundsPattern pattern = new BoundsPattern().match(description);

        Bound[] bounds = new Bound[2];

        bounds[0] = pattern.openingBraceIsStrict() ?
                new StrictBound(pattern.getLowerNumber()) :
                new SoftBound(pattern.getLowerNumber());

        bounds[1] = pattern.closingBraceIsStrict() ?
                new StrictBound(pattern.getUpperNumber()) :
                new SoftBound(pattern.getUpperNumber());

        return bounds;
    }
}
