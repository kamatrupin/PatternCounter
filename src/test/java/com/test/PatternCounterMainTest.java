package com.test;

import com.test.exception.UnsupportedPatternException;
import com.test.util.Util;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rkamat on 3/10/2018.
 */
public class PatternCounterMainTest {

    private static String inputFileContents = null;
    private static String insufficientInputFileContents = null;
    private static String expectedOutputWordPattern = null;
    private static String expectedOutputNumberPattern = null;
    private static String expectedOutputPhrasePattern = null;

    @BeforeClass
    public static void beforeClass() throws URISyntaxException, IOException {
        // Read test files from resources folder
        inputFileContents = Util.readFileAsString(new File(PatternCounterMainTest.class.getClassLoader().getResource("Input.txt").getFile()).getAbsolutePath());
        insufficientInputFileContents = Util.readFileAsString(new File(PatternCounterMainTest.class.getClassLoader().getResource("InsufficientInput.txt").getFile()).getAbsolutePath());

        expectedOutputWordPattern = Util.readFileAsString(new File(PatternCounterMainTest.class.getClassLoader().getResource("ExpectedOutputWordPattern.txt").getFile()).getAbsolutePath());
        expectedOutputNumberPattern = Util.readFileAsString(new File(PatternCounterMainTest.class.getClassLoader().getResource("ExpectedOutputNumberPattern.txt").getFile()).getAbsolutePath());
        expectedOutputPhrasePattern = Util.readFileAsString(new File(PatternCounterMainTest.class.getClassLoader().getResource("ExpectedOutputPhrasePattern.txt").getFile()).getAbsolutePath());
    }

    @Test
    public void testWordPatternCounterSuccess() throws IOException {
        String outputFilePath = PatternCounterMain.execute(inputFileContents, Util.PATTERN_WORD);
        String fileContents = Util.readFileAsString(outputFilePath);
        assertEquals(expectedOutputWordPattern, fileContents);
        deleteOutputFile(outputFilePath);
    }

    @Test
    public void testNumberPatternCounterSuccess() throws IOException {
        String outputFilePath = PatternCounterMain.execute(inputFileContents, Util.PATTERN_NUMBER);
        String fileContents = Util.readFileAsString(outputFilePath);
        assertEquals(expectedOutputNumberPattern, fileContents);
        deleteOutputFile(outputFilePath);
    }

    @Test
    public void testPhrasePatternCounterSuccess() throws IOException {
        String outputFilePath = PatternCounterMain.execute(inputFileContents, Util.PATTERN_PHRASE);
        String fileContents = Util.readFileAsString(outputFilePath);
        assertEquals(expectedOutputPhrasePattern, fileContents);
        deleteOutputFile(outputFilePath);
    }

    @Test
    public void testPatternCounterWithInsufficientInput() throws IOException {
        String outputFilePath = PatternCounterMain.execute(insufficientInputFileContents, Util.PATTERN_WORD);
        String fileContents = Util.readFileAsString(outputFilePath);
        assertTrue(fileContents.isEmpty());
        deleteOutputFile(outputFilePath);
    }

    @Test(expected = UnsupportedPatternException.class)
    public void testUnsupportedPattern() throws IOException {
        PatternCounterMain.execute(inputFileContents, Util.PATTERN_UNSUPPORTED);
    }

    private void deleteOutputFile(String filePath) throws IOException {
        // Delete the output file
        Files.deleteIfExists(Paths.get(filePath));
    }
}
