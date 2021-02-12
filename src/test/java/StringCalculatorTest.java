

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

    @Test
    public void shouldReturnSumForMultiDelimter() {
        int actualSum = StringCalculator.add("1\n2,3");
        assertEquals(6, actualSum);
    }

    @Test
    public void shouldReturnSumForPrefixedDelimiter() {
        int actualSum = StringCalculator.add("//;\n1;2");
        assertEquals(3, actualSum);
    }

    @Test
    public void shouldThrowExceptionForSingleNegativeNumber() {
        Exception exception = assertThrows(RuntimeException.class, () -> StringCalculator.add("//;\n-1;2"));
        assertEquals("Negative Number found [-1]", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionForMultipleNegativeNumber() {
        Exception exception = assertThrows(RuntimeException.class, () -> StringCalculator.add("//;\n-1;-2"));
        assertEquals("Negative Number found [-1, -2]", exception.getMessage());
    }

    @Test
    public void shouldIgnoreNumberGreaterThan1000() {
        int actualSum = StringCalculator.add("//;\n1001;2");
        assertEquals(2, actualSum);
    }

    @Test
    public void shouldAddWhenDelimiterLengthGreaterThan1() {
        int actualSum = StringCalculator.add("//[ppp]\n1ppp2ppp3");
        assertEquals(6, actualSum);
    }

    @Test
    public void shouldAddWhenDelimiterContainsSpecialChar() {
        int actualSum = StringCalculator.add("//[***]\n1***2***3");
        assertEquals(6, actualSum);
    }

    @Test
    public void shouldAddWhenMultipleDelimiter() {
        int actualSum = StringCalculator.add("//[*][%]\n1*2%3");
        assertEquals(6, actualSum);
    }

}