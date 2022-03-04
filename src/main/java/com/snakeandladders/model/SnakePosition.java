package com.snakeandladders.model;

public class SnakePosition extends Position {
    public SnakePosition(int startPosition, int endPosition) {
        super(startPosition, endPosition);
        if (endPosition >= startPosition) {
            throw  new AssertionError();
        }
    }
}
