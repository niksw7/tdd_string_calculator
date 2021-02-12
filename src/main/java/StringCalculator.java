import java.util.Arrays;

public class StringCalculator {
    public static int add(String input) {
        return Arrays
                .stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
