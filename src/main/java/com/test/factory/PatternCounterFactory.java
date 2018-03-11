package com.test.factory;

import com.test.PatternCounter;
import com.test.exception.UnsupportedPatternException;
import com.test.impl.NumberPatternCounter;
import com.test.impl.PhrasePatternCounter;
import com.test.impl.WordPatternCounter;
import com.test.util.Util;

/**
 * Created by rkamat on 3/9/2018.
 */
public class PatternCounterFactory {

    public static PatternCounter create(String pattern) {
        switch (pattern) {
            case (Util.PATTERN_WORD):
                return new WordPatternCounter();
            case (Util.PATTERN_NUMBER):
                return new NumberPatternCounter();
            case (Util.PATTERN_PHRASE):
                return new PhrasePatternCounter();
            default:
                throw new UnsupportedPatternException("Pattern not supported !!!");
        }
    }
}
