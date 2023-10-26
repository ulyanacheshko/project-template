package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    //@Nullable Session state();

    @NotNull String message();

    record Defeat(SecretWord secretWord) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You lost!, word – " + secretWord.getSecretWord();
        }
    }

    record Win() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You won!";
        }
    }

}
