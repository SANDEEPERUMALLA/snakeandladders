package com.snakeandladders;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.metrics.AggregatedStats;
import com.snakeandladders.metrics.IMetricsPublisher;
import com.snakeandladders.metrics.MetricsProcessor;
import com.snakeandladders.metrics.MetricsPublisher;
import com.snakeandladders.model.*;
import com.snakeandladders.services.ConfigBasedBoardGenerator;
import com.snakeandladders.services.FakeDice;
import com.snakeandladders.services.IBoardGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeAndLadderSimulationTest {

    @Test
    void runSimulationWithTwoPlayers1() {
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
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        metricsPublisher.register(metricsProcessor);
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        Game game = new Game(board, players, new FakeDice(
                List.of(5, 1, 5, 1, 5, 5, 1, 4, 4, 5, 1, 2, 5, 2, 2, 2, 1, 2, 5, 1, 4, 2, 4, 3, 2, 4, 1, 4, 2, 1, 3, 4,
                        1, 1, 4, 5, 2, 3, 1, 5, 1, 2, 1, 5, 2, 4, 3, 5, 4, 1, 2, 4, 1)), metricsPublisher);
        game.play();
        Player winnerPlayer = metricsProcessor.getStatsByGameId(game.getGameId()).getWinnerPlayer();
        assertEquals("JC", winnerPlayer.getShortName());
    }

    @Test
    void runSimulationWithTwoPlayers2() {
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(88, 55), Position.of(57, 31), Position.of(4, 2),
                Position.of(56, 34), Position.of(86, 44));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(25, 72), Position.of(48, 61), Position.of(6, 22),
                Position.of(79, 90), Position.of(70, 71));

        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        System.out.println(boardConfig);
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        metricsPublisher.register(metricsProcessor);
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        Game game = new Game(board, players, new FakeDice(
                List.of(1, 5, 6, 3, 4, 2, 1, 1, 2, 4, 3, 4, 6, 3, 5, 3, 4, 6, 6, 6, 6, 1, 6, 3, 1, 2, 6, 4, 3, 2, 6, 2,
                        2, 2, 3, 1, 2, 3, 5, 3, 2, 3, 4, 4, 4, 1, 2, 1, 3)), metricsPublisher);
        game.play();
        Player winnerPlayer = metricsProcessor.getStatsByGameId(game.getGameId()).getWinnerPlayer();
        assertEquals("RM", winnerPlayer.getShortName());
    }

    @Test void runSimulationWithTwoPlayer3() {
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(74, 58), Position.of(35, 32), Position.of(5, 1),
                Position.of(14, 7), Position.of(65, 10));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(74, 89), Position.of(39, 80), Position.of(12, 68),
                Position.of(27, 88), Position.of(65, 70));

        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        System.out.println(boardConfig);
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        metricsPublisher.register(metricsProcessor);
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        Game game = new Game(board, players, new FakeDice(
                List.of(2, 5, 1, 3, 3, 5, 2, 6, 6, 3, 5, 4, 3, 2, 4, 1, 3, 3, 6, 4, 5, 4, 1, 6, 4, 1, 6, 2, 4, 5, 2, 1,
                        2, 2, 4, 5, 6, 6, 6, 1, 3, 1)), metricsPublisher);
        game.play();
        Player winnerPlayer = metricsProcessor.getStatsByGameId(game.getGameId()).getWinnerPlayer();
        assertEquals("RM", winnerPlayer.getShortName());
    }

    @Test
    void runSimulationWithThreePlayers() {

        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(81, 13), Position.of(95, 88), Position.of(21, 5),
                Position.of(19, 10), Position.of(7, 1));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(65, 89), Position.of(87, 92), Position.of(28, 48),
                Position.of(56, 66), Position.of(60, 69));
        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        System.out.println(boardConfig);
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        metricsPublisher.register(metricsProcessor);
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build(),
                Player.builder().firstName("Raj").lastName("Khanna").age(30).build());
        Game game = new Game(board, players, new FakeDice(
                List.of(3, 6, 1, 5, 2, 1, 3, 4, 6, 3, 4, 3, 5, 3, 6, 1, 3, 3, 1, 4, 5, 3, 2, 3, 6, 5, 5, 6, 2, 3, 2, 2,
                        4, 5, 2, 6, 5, 3, 1, 6, 2, 1, 5, 3, 6, 2, 5, 5, 5, 2, 4, 6, 5, 5, 4, 2, 3, 3, 6, 5, 2, 2, 4, 2,
                        5, 5, 3, 5, 4, 1, 2, 3, 6, 3, 5, 2, 4, 1)), metricsPublisher);
        game.play();
        Player winnerPlayer = metricsProcessor.getStatsByGameId(game.getGameId()).getWinnerPlayer();
        assertEquals("JC", winnerPlayer.getShortName());
    }

}
