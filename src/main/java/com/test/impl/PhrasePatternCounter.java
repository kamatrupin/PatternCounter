package com.test.impl;

import com.test.PatternCounter;
import com.test.util.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rkamat on 3/9/2018.
 */
public class PhrasePatternCounter implements PatternCounter {

    public Map<String, Integer> count(String tokenArr []) {

        Map<String, Integer> countMap = new HashMap<>();

        for(int i=0; i<tokenArr.length - 2; i++) {
            StringBuffer sbug = new StringBuffer();
            sbug.append(tokenArr[i]).append(" ").append(tokenArr[i+1]).append(" ").append(tokenArr[i+2]);

            Util.populateCountMap(sbug.toString(), countMap);
        }

        return countMap;
    }
}
