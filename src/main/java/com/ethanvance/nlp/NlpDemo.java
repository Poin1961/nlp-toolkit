package com.ethanvance.nlp;

import com.ethanvance.nlp.core.Tokenizer;
import com.ethanvance.nlp.sentiment.SentimentAnalyzer;
import com.ethanvance.nlp.ner.NamedEntityRecognizer;

public class NlpDemo {
    public static void main(String[] args) {
        String text = "Dr. Ethan Vance, a senior AI engineer at Google, announced a breakthrough in NLP today.";

        // Tokenization
        System.out.println("Tokens: " + Tokenizer.tokenize(text));

        // Sentiment Analysis
        System.out.println("Sentiment: " + SentimentAnalyzer.analyze(text));

        // Named Entity Recognition
        System.out.println("Named Entities: " + NamedEntityRecognizer.recognize(text));
    }
}
