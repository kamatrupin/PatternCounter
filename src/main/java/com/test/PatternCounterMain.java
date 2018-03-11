package com.test;

import com.test.factory.PatternCounterFactory;
import com.test.util.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkamat on 3/9/2018.
 */
public class PatternCounterMain {
    public static void main(String args []) throws IOException {

        if(args.length <2) {
            System.out.println("Input File and Pattern is mandatory");
            System.out.println("Hint: java -jar PatternCounter.jar Input.txt 1");
            return;
        }

        try {
            String filePath = args[0];
            String pattern = args[1];

            // Read the file contents
            final String fileContents = Util.readFileAsString(filePath);

            System.out.println("Please check the file for output: " + execute(fileContents, pattern));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static String execute(String fileContents, String pattern) throws IOException {

        Map<String, Integer> countMap = null;
        String [] tokenArr = fileContents.split(" ");

        // Create pattern impl for the input pattern
        PatternCounter patternCounter = PatternCounterFactory.create(pattern);

        if(tokenArr.length >= 3) {
            // Count only if the input file has more than 3 words
            countMap = patternCounter.count(tokenArr);
        } else {
            // Create empty output if input file has less than 3 words
            countMap = new HashMap<>();
            System.out.println("Insufficient content in the input file !!!");
        }

        // Write output to the file
        return patternCounter.writeOccuranceCountToOutputFile(countMap);
    }
}
