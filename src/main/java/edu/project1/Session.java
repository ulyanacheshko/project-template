package edu.project1;

import java.util.Scanner;


public class Session {

    private final int maxAttempts = 5;
    private final static Scanner SCANNER = new Scanner(System.in);
    private final String answer;
    private int attempts = 0;
    private String wrongUserAttempts = "";

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public Session(String answer, int attempts) {
        this.answer = answer;
        this.attempts = attempts;
    }

    protected boolean userWins(char[] userWord, String answer) {
        return answer.equals(String.valueOf(userWord));
    }

    GuessResult gameLoop(SecretWord secretWord) {

        secretWord.maskedAnswerArray(answer);
        Print.printInfo(this, secretWord);
        while (attempts < maxAttempts && !userWins(secretWord.getMaskedAnswer(), answer)) {
            Character letter = SCANNER.next().charAt(0);
            int index = answer.indexOf(letter);
            if (!secretWord.openLetter(index, letter) && isCorrectLetter(letter)) {
                wrongUserAttempts += letter;
                attempts++;
                Print.printAttempts(this);

            } else if (!secretWord.openLetter(index, letter) && !isCorrectLetter(letter)) {

                Print.printAlreadyEntered();
            } else {
                Print.printHit();
            }
            Print.printInfo(this, secretWord);

        }

        if (userWins(secretWord.getMaskedAnswer(), answer)) {
            Print.printWin();
            return new GuessResult.Win();

        } else {
            Print.printLosing(secretWord);
            return new GuessResult.Defeat(secretWord);
        }

    }

    private boolean isCorrectLetter(Character letter) {
        return (letter >= 'a' && letter <= 'z' && !wrongUserAttempts.contains(String.valueOf(letter)));
    }
}
