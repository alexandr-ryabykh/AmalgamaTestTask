package api.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class VarietyPattern {
    private Pattern pattern = Pattern.compile("([\\(\\[][^\\[\\]\\(\\)]+[\\)\\]])");

    public ArrayList<String> match(String description) {
        Matcher matcher = pattern.matcher(description);
        ArrayList<String> results = new ArrayList();

        while (matcher.find()) {
            results.add(matcher.group());
        }

        return results;
    }
}
