import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        String regex = "[,\n]";
        if (input.startsWith("//")) {
            regex = input.substring(2, 3);
            input = input.substring(4);
        }
        validateInput(input, regex);
        return Arrays
                .stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .filter(num-> num<1000)
                .sum();
    }

    private static void validateInput(String input, String regex) {
        Collection<String> negativeNumbers = Arrays.stream(input.split(regex)).filter(num -> num.contains("-")).collect(Collectors.toList());
        if (negativeNumbers.size() != 0) {
            throw new RuntimeException("Negative Number found " + negativeNumbers);
        }

    }

}
