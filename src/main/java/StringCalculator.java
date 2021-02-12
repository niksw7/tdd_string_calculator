import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        String regex = "[,\n]";
        if (input.startsWith("//")) {
            Pattern pattern = Pattern.compile(Pattern.quote("//") + "(.*?)" + Pattern.quote("\n"));
            Matcher m = pattern.matcher(input);
            if (m.find()) {
                String group = m.group(1);
                if (group.length() > 1)
                    regex = group.substring(1, group.length() - 1);
                else
                    regex = group;
                regex = regex.replaceAll("\\*", "\\\\*");//can add multiple conditions for regex
            }
            input = input.substring(input.indexOf('\n') + 1);
        }
        validateInput(input, regex);
        return Arrays
                .stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 1000)
                .sum();
    }

    private static void validateInput(String input, String regex) {
        Collection<String> negativeNumbers = Arrays.stream(input.split(regex)).filter(num -> num.contains("-")).collect(Collectors.toList());
        if (negativeNumbers.size() != 0) {
            throw new RuntimeException("Negative Number found " + negativeNumbers);
        }

    }

}
