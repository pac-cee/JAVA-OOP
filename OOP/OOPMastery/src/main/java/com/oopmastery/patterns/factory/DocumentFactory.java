package com.oopmastery.patterns.factory;

/**
 * Factory pattern example demonstrating object creation through a factory method.
 * Shows:
 * 1. Factory method pattern
 * 2. Object creation delegation
 * 3. Type-based instantiation
 */
public class DocumentFactory {
    public static Document createDocument(DocumentType type, String content) {
        return switch (type) {
            case PDF -> new PdfDocument(content);
            case WORD -> new WordDocument(content);
            case TEXT -> new TextDocument(content);
            default -> throw new IllegalArgumentException("Unsupported document type: " + type);
        };
    }
}

interface Document {
    void open();
    void save();
    String getContent();
    String getFileExtension();
}

enum DocumentType {
    PDF, WORD, TEXT
}

class PdfDocument implements Document {
    private final String content;

    PdfDocument(String content) {
        this.content = content;
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document...");
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}

class WordDocument implements Document {
    private final String content;

    WordDocument(String content) {
        this.content = content;
    }

    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document...");
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getFileExtension() {
        return ".docx";
    }
}

class TextDocument implements Document {
    private final String content;

    TextDocument(String content) {
        this.content = content;
    }

    @Override
    public void open() {
        System.out.println("Opening text document...");
    }

    @Override
    public void save() {
        System.out.println("Saving text document...");
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
} 