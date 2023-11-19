package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static edu.hw1.NestedArray.isNestable;

class NestedArrayTest {
    @Test
    @DisplayName("Первый массив может быть вложен во второй")
    void ArrayAIsNestedInArrayB(){
        int[] inputA = {1, 2, 3, 4};
        int[] inputB = {0,6};
        boolean response = isNestable(inputA,inputB);
        assertThat(response).isEqualTo(true);
    }
    @Test
    @DisplayName("Первый массив не может быть вложен во второй")
    void ArrayAIsNotNestedInArrayB(){
        int[] inputA = {1,2,3,4};
        int[] inputB = {2,3};
        boolean response = isNestable(inputA,inputB);
        assertThat(response).isEqualTo(false);
    }
    @Test
    @DisplayName("Первый массив нулевой")
    void ArrayAIsNull(){
        int[] inputA = null;
        int[] inputB = {3,7,1,8};
        assertThatThrownBy(() -> isNestable(inputA,inputB)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("Второй массив нулевой")
    void ArrayBIsNull(){
        int[] inputA = {1,2,3,4,5,6};
        int[] inputB = null;
        assertThatThrownBy(() -> isNestable(inputA,inputB)).isInstanceOf(IllegalArgumentException.class);
    }

}
