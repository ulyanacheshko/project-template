package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static edu.hw1.Knights.knightBoardCapture;

class KnightsTest {
    @Test
    @DisplayName("Ни один конь не может захватить другого")
    void knightBoardCaptureTrueTest() {
        int[][] input = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };
        boolean response = knightBoardCapture(input);
        assertThat(response).isEqualTo(true);
    }

    @Test
    @DisplayName("Один из коней может захватить другого")
    void knightBoardCaptureFalseTest() {
        int[][] input = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };
        boolean response = knightBoardCapture(input);
        assertThat(response).isEqualTo(false);
    }

    @Test
    @DisplayName("Некорректные входные данные")
    void knightBoardCaptureIncorrectInput() {
        int[][] input = {
            {1, 0, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0},
            {1, 0, 0, 0, 1}
        };
        assertThatThrownBy(() -> knightBoardCapture(input)).isInstanceOf(IllegalArgumentException.class);
    }

}
