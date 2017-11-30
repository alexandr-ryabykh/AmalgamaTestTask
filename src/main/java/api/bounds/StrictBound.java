package api.bounds;

public class StrictBound extends Bound {
    public StrictBound(Float value) {
        super(value);
    }

    public String getLowerChar() {
        return "(";
    }

    public String getUpperChar() {
        return ")";
    }

    protected boolean isLessThan(Float value, Float other) {
        return value <= other;
    }
}
