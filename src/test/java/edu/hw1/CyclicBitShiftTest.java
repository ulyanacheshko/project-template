package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import static edu.hw1.Knights.knightBoardCapture;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.provider.CsvSource;
import static edu.hw1.CyclicBitShift.*;

class CyclicBitShiftTest {
    @DisplayName("Циклический сдвиг влево")
    @ParameterizedTest(name = " {0} на {1} влево -> {2} ")
    @CsvSource({
        "17,2,6",
        "16,1,1",
        "12,3,6"
    }
    )
    void CyclingBitShiftLeftTest(int input,int shiftInput, int expected) {
       int response = rotateLeft(input,shiftInput);
        assertThat(response).isEqualTo(expected);
    }

    @DisplayName("Циклический сдвиг вправо")
    @ParameterizedTest(name = " {0} на {1} вправо -> {2} ")
    @CsvSource({
        "8,1,4",
        "18,2,20",
        "25,1,28"
    })
    void CyclingBitShiftRightTest(int input,int shiftInput, int expected) {
        int response = rotateRight(input,shiftInput);
        assertThat(response).isEqualTo(expected);
    }

    @DisplayName("Число или размер циклического сдвига меньше 0 (сдвиг влево)")
    @ParameterizedTest(name = " {0} на {1} влево -> Wrong input ")
    @CsvSource({
        "8,-1",
        "-18,1",
        "-2,-2"
    }
    )
    void CyclingBitShiftLeftNegativeInput(int input,int shiftInput) {
        assertThatThrownBy(() -> rotateLeft(input,shiftInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Число или размер циклического сдвига меньше 0 (сдвиг вправо)")
    @ParameterizedTest(name = " {0} на {1} вправо -> Wrong input ")
    @CsvSource({
        "10,-2",
        "-13,1",
        "-1,-1"
    }
    )
    void CyclingBitShiftRightNegativeInput(int input,int shiftInput) {
        assertThatThrownBy(() -> rotateRight(input,shiftInput)).isInstanceOf(IllegalArgumentException.class);
    }
}
