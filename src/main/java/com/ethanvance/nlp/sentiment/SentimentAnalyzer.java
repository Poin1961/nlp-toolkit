package com.ethanvance.nlp.sentiment;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A rule-based sentiment analyzer that classifies text as positive, negative, or neutral.
 * This analyzer uses predefined lists of positive and negative words to determine sentiment.
 * For more advanced sentiment analysis, machine learning models would typically be employed.
 */
public class SentimentAnalyzer {

    private final Set<String> positiveWords;
    private final Set<String> negativeWords;

    public SentimentAnalyzer() {
        positiveWords = new HashSet<>(Arrays.asList(
                "good", "great", "excellent", "awesome", "fantastic", "love", "happy",
                "joy", "positive", "wonderful", "amazing", "brilliant", "superb"
        ));
        negativeWords = new HashSet<>(Arrays.asList(
                "bad", "terrible", "horrible", "awful", "hate", "sad",
                "angry", "negative", "poor", "disappointing", "frustrating", "ugly"
        ));
    }

    /**
     * Analyzes the sentiment of a given text.
     *
     * @param text The input text to analyze.
     * @return A string representing the sentiment: "Positive", "Negative", or "Neutral".
     */
    public String analyzeSentiment(String text) {
        if (text == null || text.isEmpty()) {
            return "Neutral";
        }

        String lowerCaseText = text.toLowerCase();
        int positiveScore = 0;
        int negativeScore = 0;

        // Simple word matching for sentiment scoring
        for (String word : lowerCaseText.split("\\s+")) {
            if (positiveWords.contains(word)) {
                positiveScore++;
            } else if (negativeWords.contains(word)) {
                negativeScore++;
            }
        }

        if (positiveScore > negativeScore) {
            return "Positive";
        } else if (negativeScore > positiveScore) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        String text1 = "This is a fantastic movie, I love it!";
        System.out.println("\"" + text1 + "\" -> " + analyzer.analyzeSentiment(text1));

        String text2 = "The service was terrible and very disappointing.";
        System.out.println("\"" + text2 + "\" -> " + analyzer.analyzeSentiment(text2));

        String text3 = "It was an okay experience.";
        System.out.println("\"" + text3 + "\" -> " + analyzer.analyzeSentiment(text3));

        String text4 = "I am happy today.";
        System.out.println("\"" + text4 + "\" -> " + analyzer.analyzeSentiment(text4));

        String text5 = "I hate this bad situation.";
        System.out.println("\"" + text5 + "\" -> " + analyzer.analyzeSentiment(text5));
    }
}
