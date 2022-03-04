package com.snakeandladders.config;

import com.snakeandladders.model.Position;

import java.util.List;

public class BoardConfig {

    private final List<Position> snakePositions;
    private final List<Position> ladderPositions;

    public BoardConfig(List<Position> snakePositions, List<Position> ladderPositions) {

        this.snakePositions = snakePositions;
        this.ladderPositions = ladderPositions;
    }

    public List<Position> getSnakePositions() {
        return snakePositions;
    }

    public List<Position> getLadderPositions() {
        return ladderPositions;
    }

    @Override public String toString() {
        return "[snakePositions" + snakePositions.toString() + ", ladderPositions:" + ladderPositions.toString() + "]";
    }
}
