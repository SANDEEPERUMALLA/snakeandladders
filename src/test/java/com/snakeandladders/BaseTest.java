package com.snakeandladders;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.model.Position;

import java.util.List;

public class BaseTest {

    protected BoardConfig setupBoardWithStaticConfig() {
        //Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(4, 25), Position.of(17, 89), Position.of(45, 99));
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(98, 2), Position.of(55, 15), Position.of(76, 14));
        return new BoardConfig(snakePositions, ladderPositions);
    }
}
