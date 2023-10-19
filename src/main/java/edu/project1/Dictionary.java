package edu.project1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private List<String> listWords;
    private final String filename;
    final int MinWordLength = 5;
    final int MaxWordLength = 10;

    public Dictionary(String filename) {
        this.filename = filename;
        loadListWordsFromFile();
    }

    protected void loadListWordsFromFile() {
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream(filename);
        if (resource == null) {
            throw new IllegalArgumentException(filename + " not found");
        }
        listWords = new BufferedReader(new InputStreamReader(resource)).lines().toList();
    }

    protected String getRandomWordFromList() {
        final int MinWordLength = 5;
        final int MaxWordLength = 10;
        String word = listWords.get(new Random().nextInt(listWords.size()));
        while (isNotValidWord(word)) {
            word = listWords.get(new Random().nextInt(listWords.size()));
        }
        return word;
    }

    protected boolean isNotValidWord(String word) {
        return word.length() < MinWordLength || word.length() > MaxWordLength;
    }

}
