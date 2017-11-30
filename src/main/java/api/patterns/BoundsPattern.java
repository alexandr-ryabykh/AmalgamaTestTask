package api.patterns;

import api.braces.ClosingBrace;
import api.braces.OpeningBrace;
import api.braces.Brace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundsPattern {
    private String openingBracePattern = "(?<openingBrace>[\\[\\(])\\s*";
    private String firstNumberPattern = "(?<firstNumber>\\-?\\+?Infinity|\\-?\\+?\\d+\\.?\\d*)\\s*";
    private String secondNumberPattern = ",\\s*(?<secondNumber>\\+?Infinity|\\-?\\+?\\d+\\.?\\d*)";
    private String closingBracePattern = "\\s*(?<closingBrace>[\\]\\)])";

    private Brace closingBrace;
    private Brace openingBrace;
    private Float lowerNumber;
    private Float upperNumber;

    public boolean openingBraceIsStrict() {
        return this.openingBrace.isStrict();
    }

    public boolean closingBraceIsStrict() {
        return this.closingBrace.isStrict();
    }

    public Float getLowerNumber() {
        return this.lowerNumber;
    }

    public Float getUpperNumber() {
        return this.upperNumber;
    }

    public BoundsPattern match(String description) {
        Matcher matcher =  this.compilePattern().matcher(description);

        if (matcher.matches()) {
            this.saveMatchedResults(matcher);
        }

        return this;
    }

    private void saveMatchedResults(Matcher matcher) {
        this.openingBrace = new OpeningBrace(matcher.group("openingBrace"));
        this.closingBrace = new ClosingBrace(matcher.group("closingBrace"));
        this.lowerNumber = Float.parseFloat(matcher.group("firstNumber"));
        this.upperNumber = Float.parseFloat(matcher.group("secondNumber"));
    }

    private Pattern compilePattern() {
        return Pattern.compile(
                this.openingBracePattern
                        + this.firstNumberPattern
                        + this.secondNumberPattern
                        + this.closingBracePattern
        );
    }
}
