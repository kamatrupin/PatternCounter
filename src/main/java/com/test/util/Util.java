package com.test.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rkamat on 3/9/2018.
 */
public class Util {

    public static final String PATTERN_WORD = "1";
    public static final String PATTERN_NUMBER = "2";
    public static final String PATTERN_PHRASE = "3";
    public static final String PATTERN_UNSUPPORTED = "4";
    public static final String REGEX_REPLACE_NEWLINE_CHAR = "[\r\n]+";

    public static final String OUTPUT_FILE_NAME = "PatternCounterOutput.txt";

    public static Map<String, Integer> countTokenOccurance(String tokenArr [], String regex) {
        Map<String, Integer> countMap = new LinkedHashMap<>();
        for(String token : tokenArr) {
            if(token.matches(regex)) {
                populateCountMap(token, countMap);
            }
        }
        return countMap;
    }

    public static void populateCountMap(String token, Map<String, Integer> countMap) {
        if(countMap.get(token) == null) {
            countMap.put(token, 1);
        } else {
            countMap.put(token, countMap.get(token) + 1);
        }
    }

    public static String readFileAsString(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath))).replaceAll(REGEX_REPLACE_NEWLINE_CHAR, " ");
        } catch(Exception e) {
            throw new RuntimeException("Failed to load the input file=" + filePath, e);
        }
    }

    public static String writeOutputToFile(String output) throws IOException {
        Files.write(Paths.get(OUTPUT_FILE_NAME), output.getBytes());
        return Paths.get(OUTPUT_FILE_NAME).toAbsolutePath().toString();
    }
}
