import java.util.Arrays;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return Arrays
                .stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
