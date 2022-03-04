package com.snakeandladders.model;

public class Position {
    private final int startPosition;
    private final int endPosition;

    public Position(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public static Position of(int startPosition, int endPosition) {
        return new Position(startPosition, endPosition);
    }
}
