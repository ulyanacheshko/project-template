package edu.hw2.task1;

public record Constant(double x) implements Expr {
    @Override
    public double evaluate() {
        return x;
    }
}
