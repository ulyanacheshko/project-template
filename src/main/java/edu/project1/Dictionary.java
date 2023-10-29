package edu.project1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private List<String> listWords;
    private final String filename;
    final int minWordLength = 5;
    final int maxWordLength = 10;

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
        String word = listWords.get(new Random().nextInt(listWords.size()));
        String validWord = word;
        boolean noAnyValidWords =
            listWords.stream().anyMatch(s -> validWord.length() < minWordLength || validWord.length() > maxWordLength);
        if (noAnyValidWords) {
            throw new IllegalArgumentException("File doesn't have valid words");
        }
        while (isNotValidWord(validWord)) {
            word = listWords.get(new Random().nextInt(listWords.size()));
        }
        return word;
    }
      

    protected boolean isNotValidWord(String word) {
        return word.length() < minWordLength || word.length() > maxWordLength;
    }

}
