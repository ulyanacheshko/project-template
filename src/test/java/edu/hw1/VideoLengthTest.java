package edu.hw1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.VideoLength.minutesToSeconds;

class VideoLengthTest {

    @Test
    @DisplayName("Корректные данные")
    void correctInput() {
        String input = "45:20";
        int response = minutesToSeconds(input);
        assertThat(response).isEqualTo(2720);
    }

    @Test
    @DisplayName("Минут больше чем 60")
    void minutesMoreThenSixty() {
        String input = "999:59";
        int response = minutesToSeconds(input);
        assertThat(response).isEqualTo(59999);
    }

    @Test
    @DisplayName("Секунд больше чем 60")
    void secondsMoreThenSixty() {
        String input = "10:63";
        int response = minutesToSeconds(input);
        assertThat(response).isEqualTo(-1);

    }

    @Test
    @DisplayName("Нулевое значение")
    void InputIsNull() {
        String input = "00:00";
        int response = minutesToSeconds(input);
        assertThat(response).isEqualTo(0);

    }

}
