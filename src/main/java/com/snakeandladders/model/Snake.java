package com.snakeandladders.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Snake snake = (Snake)o;
        return startPosition == snake.startPosition && endPosition == snake.endPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition);
    }

    @Override
    public String toString() {
        return "S:" + startPosition + "->" + endPosition;
    }


}
