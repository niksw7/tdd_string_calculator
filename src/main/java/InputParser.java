import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public ParsedData parse(String input) {
        String regex = "[,\n]";
        if (input.startsWith("//")) {
            Pattern pattern = Pattern.compile(Pattern.quote("//") + "(.*?)" + Pattern.quote("\n"));
            Matcher m = pattern.matcher(input);
            if (m.find()) {
                String group = m.group(1);
                if (group.length() > 1)
                    regex = getRegexForDelimiter(group);
                else
                    regex = group;
                regex = regex.replaceAll("\\*", "\\\\*");//can add multiple conditions for regex
            }
            input = input.substring(input.indexOf('\n') + 1);
        }
        return new ParsedData(input, regex);
    }

    private String getRegexForDelimiter(String group) {
        Pattern pattern = Pattern.compile(Pattern.quote("[") + "(.*?)" + Pattern.quote("]"));
        Matcher m = pattern.matcher(group);
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            sb.append(m.group(1));
            sb.append('|');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
