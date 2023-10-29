package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.*;

class DictionaryTest {

    @DisplayName("Загаданное слово имеет некорректную длину")
    @Test
    void incorrectWordLength() {
        boolean isException = false;
        Dictionary dictionary = new Dictionary("dictionary.txt");
        String input = "sun";
        try {
            if (dictionary.isNotValidWord(input)) {
                throw new IllegalArgumentException("The hidden word has an incorrect length");
            }
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertThat(true).isEqualTo(isException);
    }

    @DisplayName("Файл найден")
    @Test
    void notNullResource() {
        boolean isException = false;
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("dictionary.txt");
        try {
            if (resource == null) {
                throw new IllegalArgumentException("dictionary.txt" + " not found");
            }
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertThat(false).isEqualTo(isException);
    }

    @DisplayName("Файл не найден")
    @Test
    void nullResource() {
        boolean isException = false;
        InputStream resource = null;
        try {
            if (resource == null) {
                throw new IllegalArgumentException("dictionary.txt" + " not found");
            }
        } catch (IllegalArgumentException e) {
            isException = true;
        }
        assertThat(true).isEqualTo(isException);

    }
}
