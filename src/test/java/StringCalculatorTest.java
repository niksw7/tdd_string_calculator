

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {
    @Test
    public void shouldReturnSumForSingleNumber() {
        int actualSum = StringCalculator.add("1");
        assertEquals(1, actualSum);
    }

    @Test
    public void shouldReturnSumFor2Number() {
        int actualSum = StringCalculator.add("1,2");
        assertEquals(3, actualSum);
    }

    @Test
    public void shouldReturnSumForNull() {
        int actualSum = StringCalculator.add(null);
        assertEquals(0, actualSum);
    }
}