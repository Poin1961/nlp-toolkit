package com.ethanvance.nlp.sentiment;

import java.util.HashMap;
import java.util.Map;

public class SentimentAnalyzer {

    private static final Map<String, Integer> SENTIMENT_LEXICON = new HashMap<>();

    static {
        // Simplified sentiment lexicon for demonstration
        SENTIMENT_LEXICON.put("good", 1);
        SENTIMENT_LEXICON.put("great", 1);
        SENTIMENT_LEXICON.put("excellent", 1);
        SENTIMENT_LEXICON.put("positive", 1);
        SENTIMENT_LEXICON.put("bad", -1);
        SENTIMENT_LEXICON.put("terrible", -1);
        SENTIMENT_LEXICON.put("negative", -1);
        SENTIMENT_LEXICON.put("neutral", 0);
    }

    public static String analyze(String text) {
        if (text == null || text.isEmpty()) {
            return "Neutral";
        }

        int score = 0;
        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {
            score += SENTIMENT_LEXICON.getOrDefault(word, 0);
        }

        if (score > 0) {
            return "Positive";
        } else if (score < 0) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }
}
