import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void shouldParseInputDataForMultipleDelimiter() {
        InputParser inputParser = new InputParser();
        ParsedData parseData = inputParser.parse("//[*][%]\n1*2%3");
        assertEquals("1*2%3", parseData.input);
        assertEquals("\\*|%", parseData.regex);

    }
}