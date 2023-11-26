package edu.hw3.task1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw3.task1.AtbashCipher.atbashCipher;

class AtbashCipherTest {

    @DisplayName("Тест AtbashCipher")
    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(value = {
        "Hello world!,Svool dliow!",
        "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler,Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
    })
    public void atbashCipherTest(String input, String expected) {
        String response = atbashCipher(input);
        assertThat(response).isEqualTo(expected);
    }

    @Test
    @DisplayName("Null тест")
    public void nullTest() {
        assertThatThrownBy(() -> atbashCipher(null)).isInstanceOf(IllegalArgumentException.class);
    }

}
