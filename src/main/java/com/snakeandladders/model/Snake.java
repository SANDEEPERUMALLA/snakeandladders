package com.snakeandladders.model;

public class Snake {

    private final int startPosition;
    private final int endPosition;

    public Snake(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public String toString() {
        return "S:" + startPosition + "->" + endPosition;
    }
}
