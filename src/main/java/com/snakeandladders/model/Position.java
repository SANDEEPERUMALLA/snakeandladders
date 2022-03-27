package com.snakeandladders.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position)o;
        return startPosition == position.startPosition && endPosition == position.endPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition);
    }

    @Override
    public String toString() {
        return "(" + startPosition + "->" + endPosition + ")";
    }

}
