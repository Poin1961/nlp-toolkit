package com.ethanvance.nlp.ner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * A simple Named Entity Recognizer (NER) that identifies predefined entities
 * like persons, organizations, and locations based on a dictionary approach.
 * In a real-world scenario, this would be powered by machine learning models.
 */
public class NamedEntityRecognizer {

    private final Map<String, Set<String>> entityDictionaries;

    public NamedEntityRecognizer() {
        this.entityDictionaries = new HashMap<>();
        // Initialize with some example entities
        initializeDictionaries();
    }

    private void initializeDictionaries() {
        // Persons
        Set<String> persons = new HashSet<>();
        persons.add("Barack Obama");
        persons.add("Michelle Obama");
        persons.add("Elon Musk");
        persons.add("Sundar Pichai");
        entityDictionaries.put("PERSON", persons);

        // Organizations
        Set<String> organizations = new HashSet<>();
        organizations.add("Google");
        organizations.add("Microsoft");
        organizations.add("OpenAI");
        organizations.add("Tesla");
        entityDictionaries.put("ORGANIZATION", organizations);

        // Locations
        Set<String> locations = new HashSet<>();
        locations.add("New York");
        locations.add("London");
        locations.add("Paris");
        locations.add("San Francisco");
        entityDictionaries.put("LOCATION", locations);
    }

    /**
     * Recognizes named entities in a given text.
     *
     * @param text The input text to analyze.
     * @return A map where keys are entity types (e.g., "PERSON", "ORGANIZATION")
     *         and values are lists of recognized entities of that type.
     */
    public Map<String, List<String>> recognizeEntities(String text) {
        Map<String, List<String>> recognized = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : entityDictionaries.entrySet()) {
            String entityType = entry.getKey();
            Set<String> dictionary = entry.getValue();
            List<String> foundEntities = new ArrayList<>();

            for (String entity : dictionary) {
                if (text.contains(entity)) {
                    foundEntities.add(entity);
                }
            }
            if (!foundEntities.isEmpty()) {
                recognized.put(entityType, foundEntities);
            }
        }
        return recognized;
    }

    public static void main(String[] args) {
        NamedEntityRecognizer ner = new NamedEntityRecognizer();
        String sampleText = "Barack Obama visited New York to meet with Google executives. Elon Musk is the CEO of Tesla.";

        Map<String, List<String>> entities = ner.recognizeEntities(sampleText);

        System.out.println("\n--- Recognized Entities ---");
        entities.forEach((type, list) -> {
            System.out.println(type + ": " + list);
        });

        String anotherText = "Sundar Pichai works at Google in California.";
        Map<String, List<String>> entities2 = ner.recognizeEntities(anotherText);
        System.out.println("\n--- Recognized Entities (Another Text) ---");
        entities2.forEach((type, list) -> {
            System.out.println(type + ": " + list);
        });
    }
}
