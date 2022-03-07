package com.snakeandladders.services;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.model.*;

public class ConfigBasedBoardGenerator extends AbstractBoardGenerator {

    private final BoardConfig boardConfig;

    public ConfigBasedBoardGenerator(BoardConfig boardConfig) {
        this.boardConfig = boardConfig;
    }

    @Override
    void initLadders(BoardPosition[] boardPositions) {
        for (Position position : boardConfig.getLadderPositions()) {
            int startPosition = position.getStartPosition();
            int endPosition = position.getEndPosition();
            Ladder ladder = new Ladder(startPosition, endPosition);
            boardPositions[startPosition - 1].setLadder(ladder);
            boardPositions[endPosition - 1].setLadder(ladder);
        }
    }

    @Override
    void initSnakes(BoardPosition[] boardPositions) {
        for (Position position : boardConfig.getSnakePositions()) {
            int startPosition = position.getStartPosition();
            int endPosition = position.getEndPosition();
            Snake snake = new Snake(startPosition, endPosition);
            boardPositions[startPosition - 1].setSnake(snake);
            boardPositions[endPosition - 1].setSnake(snake);
        }
    }
}
