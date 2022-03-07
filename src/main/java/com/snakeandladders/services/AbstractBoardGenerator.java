package com.snakeandladders.services;

import com.snakeandladders.model.Board;
import com.snakeandladders.model.BoardPosition;

public abstract class AbstractBoardGenerator implements IBoardGenerator {

    @Override
    public Board generate() {
        BoardPosition[] boardPositions = initBoard();
        initSnakes(boardPositions);
        initLadders(boardPositions);
        return new Board(boardPositions);
    }

    protected BoardPosition[] initBoard() {
        BoardPosition[] boardPositions = new BoardPosition[100];
        for (int i = 0; i < 100; i++) {
            BoardPosition boardPosition = new BoardPosition(i + 1);
            boardPositions[i] = boardPosition;
        }
        return boardPositions;
    }

    abstract void initSnakes(BoardPosition[] boardPositions);
    abstract void initLadders(BoardPosition[] boardPositions);
}
