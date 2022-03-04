package com.snakeandladders.services;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.BaseTest;
import com.snakeandladders.model.Board;
import com.snakeandladders.model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigBasedBoardGenerationTest extends BaseTest {

    @Test
    void testBoardCreationWithConfigBasedGenerator() {
        BoardConfig boardConfig = setupBoardWithStaticConfig();
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        assertNotNull(configBasedBoardGenerator);
        Board board = configBasedBoardGenerator.generate();
        board.print();

        for (Position position : boardConfig.getSnakePositions()) {
            assertTrue(board.getBoardPosition(position.getStartPosition()).hasSnake());
        }

        for (Position position : boardConfig.getLadderPositions()) {
            assertTrue(board.getBoardPosition(position.getStartPosition()).hasLadder());
        }

    }
}
