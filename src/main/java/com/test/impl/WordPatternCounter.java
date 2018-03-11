package com.test.impl;

import com.test.PatternCounter;
import com.test.util.Util;

import java.util.Map;

/**
 * Created by rkamat on 3/9/2018.
 */
public class WordPatternCounter implements PatternCounter {

    private static final String REGEX_PATTERN_1 = "[a-zA-Z]+";

    public Map<String, Integer> count(String tokenArr []) {
        return Util.countTokenOccurance(tokenArr, REGEX_PATTERN_1);
    }
}
