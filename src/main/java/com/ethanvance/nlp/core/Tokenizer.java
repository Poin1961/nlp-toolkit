package com.ethanvance.nlp.core;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\b\\w+\\b");

    public static List<String> tokenize(String text) {
        if (text == null || text.isEmpty()) {
            return Arrays.asList();
        }
        Matcher matcher = WORD_PATTERN.matcher(text.toLowerCase());
        return matcher.results()
                .map(match -> match.group())
                .collect(java.util.stream.Collectors.toList());
    }
}
