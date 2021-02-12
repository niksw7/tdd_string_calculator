

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StringCalculatorTest {
    @Test
    public void shouldReturnSumForSingleNumber() {
        int actualSum = StringCalculator.add("1");
        assertEquals(1, actualSum);
    }

}