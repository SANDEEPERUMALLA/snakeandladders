package com.snakeandladders.config;

import com.snakeandladders.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardConfigTest {

    @Test
    void testBoardConfigCreation() {
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(45, 5), Position.of(31, 10), Position.of(89, 3),
                Position.of(82, 34), Position.of(63, 61));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(90, 94), Position.of(74, 82), Position.of(60, 75),
                Position.of(1, 84), Position.of(16, 33));
        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        assertEquals(snakePositions, boardConfig.getSnakePositions());
        assertEquals(ladderPositions, boardConfig.getLadderPositions());
    }
}
