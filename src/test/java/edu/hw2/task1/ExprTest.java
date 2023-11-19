package edu.hw2.task1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExprTest {
    @Test
    @DisplayName("Тест проверка всех выражений")
    public void exprTest() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        double response = res.evaluate();
        Assertions.assertThat(response).isEqualTo(37.0);
    }
}
