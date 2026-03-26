package com.ethanvance.nlp.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A robust tokenizer for natural language processing. Supports various tokenization strategies
 * including word tokenization, sentence tokenization, and handling of punctuation.
 */
public class Tokenizer {

    // Regex for basic word tokenization, handles contractions and common punctuation
    private static final Pattern WORD_PATTERN = Pattern.compile("[\\w\](?:[\\w\]|[\\w\]\[-\\w\]])*[\\w\]|\\p{Punct}");
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("[^.!?\s][^.!?]*(?:[.!?](?!\\[\\p{Lu}\\]|\\[\\d\])|$)");

    /**
     * Tokenizes a given text into a list of words.
     * This method performs basic word tokenization, splitting on whitespace and handling common punctuation.
     *
     * @param text The input string to tokenize.
     * @return A list of word tokens.
     */
    public List<String> wordTokenize(String text) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = WORD_PATTERN.matcher(text);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    /**
     * Tokenizes a given text into a list of sentences.
     * This method attempts to split the text into sentences based on common sentence-ending punctuation.
     *
     * @param text The input string to tokenize.
     * @return A list of sentence tokens.
     */
    public List<String> sentenceTokenize(String text) {
        List<String> sentences = new ArrayList<>();
        Matcher matcher = SENTENCE_PATTERN.matcher(text);
        while (matcher.find()) {
            sentences.add(matcher.group().trim());
        }
        return sentences;
    }

    /**
     * Normalizes tokens by converting them to lowercase and removing leading/trailing whitespace.
     *
     * @param tokens The list of tokens to normalize.
     * @return A new list of normalized tokens.
     */
    public List<String> normalizeTokens(List<String> tokens) {
        List<String> normalized = new ArrayList<>();
        for (String token : tokens) {
            normalized.add(token.toLowerCase().trim());
        }
        return normalized;
    }

    /**
     * Example of a more advanced tokenization method: tokenizing with stop word removal.
     * (Stop words list would typically be loaded from a resource file).
     *
     * @param text The input string to tokenize.
     * @param stopWords A list of stop words to remove.
     * @return A list of word tokens with stop words removed.
     */
    public List<String> wordTokenizeWithStopWordRemoval(String text, List<String> stopWords) {
        List<String> tokens = wordTokenize(text);
        List<String> filteredTokens = new ArrayList<>();
        for (String token : tokens) {
            if (!stopWords.contains(token.toLowerCase())) {
                filteredTokens.add(token);
            }
        }
        return filteredTokens;
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        String sampleText = "Hello, world! This is a test. How are you doing today?";

        System.out.println("\n--- Word Tokenization ---");
        List<String> words = tokenizer.wordTokenize(sampleText);
        System.out.println(words);

        System.out.println("\n--- Sentence Tokenization ---");
        List<String> sentences = tokenizer.sentenceTokenize(sampleText);
        System.out.println(sentences);

        System.out.println("\n--- Normalized Words ---");
        List<String> normalizedWords = tokenizer.normalizeTokens(words);
        System.out.println(normalizedWords);

        System.out.println("\n--- Word Tokenization with Stop Word Removal ---");
        List<String> stopWords = Arrays.asList("is", "a", "this", "how", "are", "you");
        List<String> filteredWords = tokenizer.wordTokenizeWithStopWordRemoval(sampleText, stopWords);
        System.out.println(filteredWords);
    }
}
