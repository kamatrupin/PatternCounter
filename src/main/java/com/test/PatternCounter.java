package com.test;

import com.test.util.Util;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Created by rkamat on 3/9/2018.
 */
public interface PatternCounter {
    public Map<String, Integer> count(String tokenArr []);

    default String writeOccuranceCountToOutputFile(Map<String, Integer> countMap) throws IOException {
        StringBuffer sbuf = new StringBuffer();
        countMap.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                sbuf.append(s).append(", ").append(integer).append("\n");
            }
        });
        return Util.writeOutputToFile(sbuf.toString());
    }
}
