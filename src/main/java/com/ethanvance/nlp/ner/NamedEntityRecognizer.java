package com.ethanvance.nlp.ner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NamedEntityRecognizer {

    private static final Map<String, String> ENTITY_PATTERNS = new HashMap<>();

    static {
        // Simple patterns for demonstration
        ENTITY_PATTERNS.put("PERSON", "Dr\\. [A-Z][a-z]+ [A-Z][a-z]+");
        ENTITY_PATTERNS.put("ORGANIZATION", "Google|Microsoft|OpenAI");
        ENTITY_PATTERNS.put("LOCATION", "San Francisco|New York|London");
    }

    public static List<Map<String, String>> recognize(String text) {
        List<Map<String, String>> entities = new ArrayList<>();
        for (Map.Entry<String, String> entry : ENTITY_PATTERNS.entrySet()) {
            String entityType = entry.getKey();
            String patternString = entry.getValue();
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                Map<String, String> entity = new HashMap<>();
                entity.put("text", matcher.group());
                entity.put("type", entityType);
                entities.add(entity);
            }
        }
        return entities;
    }
}
