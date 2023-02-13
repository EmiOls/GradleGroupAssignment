package core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextFileOpsTest {
    @Test
    public void testCreateAnswerMapWithBadFile() {
        assertThrows(IOException.class, () -> {
            TextFileOps.createAnswerMap("na");
        }, "IOException expected");
    }

    @Test
    public void testCreateAnswerMapWithGoodFile() throws IOException {
        assertDoesNotThrow(() -> {
            TextFileOps.createAnswerMap("capitals.txt");
        });
    }
}
