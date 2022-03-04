package com.snakeandladders.model;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.services.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.snakeandladders.logging.Logger.log;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeAndLadderSimulationTest {

    @Test void runSimulation1() {
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(45, 5), Position.of(31, 10), Position.of(89, 3),
                Position.of(82, 34), Position.of(63, 61));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(90, 94), Position.of(74, 82), Position.of(60, 75),
                Position.of(1, 84), Position.of(16, 33));

        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        System.out.println(boardConfig);
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();

        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        Game game = new Game(board, players, new FakeDice(
                List.of(5, 1, 5, 1, 5, 5, 1, 4, 4, 5, 1, 2, 5, 2, 2, 2, 1, 2, 5, 1, 4, 2, 4, 3, 2, 4, 1, 4, 2, 1, 3, 4,
                        1, 1, 4, 5, 2, 3, 1, 5, 1, 2, 1, 5, 2, 4, 3, 5, 4, 1, 2, 4, 1)));
        game.play();
        GameStats stats = game.getStats();
        assertEquals("JC", stats.getWinnerPlayer().getShortName());
    }

}
