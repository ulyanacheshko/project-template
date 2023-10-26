package edu.project1;

import java.util.Arrays;

public class SecretWord {
    private final String answer;
    private char[] maskedAnswer;

    public SecretWord(String answer) {
        this.answer = answer;
    }

    public void maskedAnswerArray(String answer) {
        maskedAnswer = new char[answer.length()];
        String symbol = "*";
        Arrays.fill(maskedAnswer, symbol.charAt(0));
    }

    public String getSecretWord() {
        return answer;
    }

    public char[] getMaskedAnswer() {
        return maskedAnswer;
    }

    public boolean openLetter(int index, Character letter) {
        boolean open = false;
        int letterIndex = index;
        while (letterIndex != -1) {
            open = true;
            maskedAnswer[letterIndex] = letter;
            letterIndex = answer.indexOf(letter, letterIndex + 1);
        }
        return open;
    }

}
