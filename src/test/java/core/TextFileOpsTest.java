package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class TextFileOpsTest {

    private static final String IOexpected = "IOException expected";
    private static final String IOunexpected = "Unexpected (IO) test error";

    @Test
    public void testCreateAnswerMapWithBadFile() {
        assertThrows(IOException.class, () -> {
            TextFileOps.createAnswerMap("na");
        }, IOexpected);
    }

    @Test
    public void testCreateAnswerMapWithGoodFile() throws IOException {
        assertDoesNotThrow(() -> {
            TextFileOps.createAnswerMap("capitals.txt");
        });
    }

    @Test
    public void testCreateCountryListWithBadFile() {
        assertThrows(IOException.class, () -> {
            TextFileOps.createCountryList("na");
        }, IOexpected);
    }

    @Test
    public void testCreateCountryListWithGoodFile() throws IOException {
        assertDoesNotThrow(() -> {
            TextFileOps.createCountryList("capitals.txt");
        });
    }

    @Test
    public void testEqualMapAndListSize() {
        try {
            var map = TextFileOps.createAnswerMap("capitals.txt");
            var list = TextFileOps.createCountryList("capitals.txt");
            assertEquals(map.size(), list.size());
        }
        catch (IOException e) {
            Assertions.fail(IOunexpected);
        }
    }

    @Test
    public void testNotEqualMapAndListSize() {
        try {
            var map = TextFileOps.createAnswerMap("capitals.txt");
            var list = List.of(1, 2, 3);
            assertNotEquals(map.size(), list.size());
        }
        catch (IOException e) {
            Assertions.fail(IOunexpected);
        }
    }
}
