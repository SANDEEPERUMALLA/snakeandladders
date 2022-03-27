package com.snakeandladders.model;

import java.util.Objects;

public class Ladder {

    private final int startPosition;
    private final int endPosition;

    public Ladder(int startPosition, int endPosition) {
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
        return "L:" + startPosition + "->" + endPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Ladder ladder = (Ladder)o;
        return startPosition == ladder.startPosition && endPosition == ladder.endPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startPosition, endPosition);
    }
}
