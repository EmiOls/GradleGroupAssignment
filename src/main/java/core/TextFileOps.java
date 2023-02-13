package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class TextFileOps {
    private static final String badFile = "The file could not be read or does not exist.";

    //This method reads the text file, makes sure that it exists and then creates a map with Countries and their capitals
    public static Map<String, String> createAnswerMap(String filename) throws IOException {
        Map<String, String> countryCapital = new HashMap<>();
        final var filePath = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            if (!Files.isReadable(filePath) || !Files.exists(filePath)) {
                throw new IOException(badFile);
            }
            String line;
            while ((line = reader.readLine()) != null) {
                var word = line.split(",");
                var country = word[0].substring(1, word[0].length() - 1);
                var capital = word[1].substring(1, word[1].length() - 1);

                countryCapital.put(country, capital);
            }
            return countryCapital;
        }
    }

    //This method reads the text file, makes sure that it exists and then creates a List with Countries
    //This process could be more efficient and has a lot of repeated code,
    //but keeping it like this allows for more tests to be written :)
    public static List<String> createCountryList(String filename) throws IOException {
        List<String> countries = new ArrayList<>();
        final var filePath = Path.of(filename);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            if (!Files.isReadable(filePath) || !Files.exists(filePath)) {
                throw new IOException(badFile);
            }
            String line;
            while ((line = reader.readLine()) != null) {
                var word = line.split(",");
                var country = word[0].substring(1, word[0].length() - 1);

                countries.add(country);
            }
            return countries;
        }

    }
}

