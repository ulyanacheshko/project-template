package edu.hw2.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    static Arguments[] rectangles() {
        return new Arguments[] {Arguments.of(new Rectangle()), Arguments.of(new Square())};
    }

    @ParameterizedTest @MethodSource("rectangles") void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);
        assertThat(rect.area()).isEqualTo(200.0);
    }

    @Test void setSide() {
        Square square = new Square();
        square = square.setSide(10);
        assertThat(square.area()).isEqualTo(100.0);
    }

}
