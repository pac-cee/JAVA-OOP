package com.oopmastery.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton pattern example demonstrating thread-safe lazy initialization.
 * Shows:
 * 1. Double-checked locking
 * 2. Private constructor
 * 3. Static instance management
 * 4. Thread safety
 */
public class Configuration {
    private static volatile Configuration instance;
    private final Map<String, String> settings;

    private Configuration() {
        settings = new HashMap<>();
        loadDefaults();
    }

    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    private void loadDefaults() {
        settings.put("app.name", "OOP Mastery");
        settings.put("app.version", "1.0.0");
        settings.put("app.environment", "development");
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public void setSetting(String key, String value) {
        settings.put(key, value);
    }

    public void clearSettings() {
        settings.clear();
        loadDefaults();
    }
} 