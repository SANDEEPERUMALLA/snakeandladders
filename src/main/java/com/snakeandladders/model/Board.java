package com.snakeandladders.model;

import java.util.StringJoiner;

import static com.snakeandladders.logging.Logger.log;

public class Board {
    BoardPosition[] boardPositions;

    public Board(BoardPosition[] boardPositions) {
        if (boardPositions.length != 100) {
            throw new AssertionError();
        }
        this.boardPositions = boardPositions;
    }

    public BoardPosition getBoardPosition(int position) {
        return boardPositions[position - 1];
    }

    public void print() {
        StringBuilder currentBoardState = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            StringJoiner boardLine = new StringJoiner(" ");
            for (int j = 0; j < 10; j++) {
                boardLine.add(boardPositions[10 * i + j].toString());
            }
            currentBoardState.append(boardLine);
            currentBoardState.append("\n");
        }
        log(currentBoardState.toString());
    }
}
