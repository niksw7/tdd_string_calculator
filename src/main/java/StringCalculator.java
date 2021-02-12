import java.util.Arrays;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        String regex = "[,\n]";
        if (input.startsWith("//")) {
            String prefix = input.substring(2, 3);
            regex = prefix;
            input = input.substring(4);
        }

        return Arrays
                .stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
