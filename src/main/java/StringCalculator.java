import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        InputParser inputParser = new InputParser();
        ParsedData parsedData = inputParser.parse(input);
        String regex = parsedData.regex;
        String parsedInput = parsedData.input;

        validateInput(parsedInput, regex);
        return Arrays
                .stream(parsedInput.split(regex))
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
