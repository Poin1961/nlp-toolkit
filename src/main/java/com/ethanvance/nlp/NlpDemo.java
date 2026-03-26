package com.ethanvance.nlp;

import com.ethanvance.nlp.core.Tokenizer;
import com.ethanvance.nlp.sentiment.SentimentAnalyzer;
import com.ethanvance.nlp.ner.NamedEntityRecognizer;

import java.util.List;
import java.util.Map;

public class NlpDemo {
    public static void main(String[] args) {
        String text = "Dr. Ethan Vance, a senior AI engineer at Google, announced a breakthrough in NLP today. This is a great achievement!";

        // Initialize components
        Tokenizer tokenizer = new Tokenizer();
        SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        NamedEntityRecognizer namedEntityRecognizer = new NamedEntityRecognizer();

        System.out.println("--- NLP Demo ---");
        System.out.println("Original Text: " + text);

        // Tokenization
        List<String> words = tokenizer.wordTokenize(text);
        System.out.println("\nWord Tokens: " + words);

        List<String> sentences = tokenizer.sentenceTokenize(text);
        System.out.println("Sentence Tokens: " + sentences);

        // Sentiment Analysis
        String sentiment = sentimentAnalyzer.analyzeSentiment(text);
        System.out.println("\nSentiment: " + sentiment);

        // Named Entity Recognition
        Map<String, List<String>> entities = namedEntityRecognizer.recognizeEntities(text);
        System.out.println("\nNamed Entities:");
        entities.forEach((type, list) -> {
            System.out.println("  " + type + ": " + list);
        });
    }
}
