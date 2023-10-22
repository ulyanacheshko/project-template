package edu.hw2.task2;

public class Square extends Rectangle {
    private int side;

    public Square(int side) {
        super(side, side);
    }

    public void setSide(int side) {
        this.side = side;
    }
}
