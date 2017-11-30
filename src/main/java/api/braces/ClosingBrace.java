package api.braces;

public class ClosingBrace implements Brace {
    private String brace;

    public ClosingBrace(String brace) {
        this.brace = brace;
    }

    public boolean isStrict() {
        return this.brace.charAt(0) == ')';
    }
}
