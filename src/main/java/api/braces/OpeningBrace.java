package api.braces;

public class OpeningBrace implements Brace {
    private String brace;

    public OpeningBrace(String brace) {
        this.brace = brace;
    }

    public boolean isStrict() {
        return this.brace.charAt(0) == '(';
    }
}
