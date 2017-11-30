package api.bounds;

public abstract class Bound {
    private Float value;

    public abstract String getLowerChar();

    public abstract String getUpperChar();

    protected abstract boolean isLessThan(Float value, Float other);

    public Bound(Float value) {
        this.value = value;
    }

    final public boolean isUpperThan(Float number) {
        return !this.isLowerThan(number);
    }

    final public boolean isUpperThan(Bound bound) {
        return !this.isLowerThan(bound);
    }

    final public boolean isLowerThan(Bound bound) {
        return this.isLessThan(this.value, bound.getValue());
    }

    final public boolean isLowerThan(Float number) {
        return this.isLessThan(this.value, number);
    }

    final public Float getValue() {
        return this.value;
    }
}
