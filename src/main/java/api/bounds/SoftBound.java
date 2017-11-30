package api.bounds;

public class SoftBound extends Bound {
    public SoftBound(Float value) {
        super(value);
    }

    public String getLowerChar() {
        return "[";
    }

    public String getUpperChar() {
        return "]";
    }

    protected boolean isLessThan(Float value, Float other) {
        return value < other;
    }
}
