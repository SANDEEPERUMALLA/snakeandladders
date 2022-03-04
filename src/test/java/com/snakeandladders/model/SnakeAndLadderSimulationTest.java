//package com.snakeandladders.model;
//
//import com.snakeandladders.config.BoardConfig;
//import com.snakeandladders.services.ConfigBasedBoardGenerator;
//import com.snakeandladders.services.IBoardGenerator;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//class SnakeAndLadderSimulationTest {
//
//    @Test
//    void runSimulation() {
//        BoardConfig boardConfig = setupBoardConfig();
//        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
//        assertNotNull(configBasedBoardGenerator);
//        Board board = configBasedBoardGenerator.generate();
//        board.print();
//        List<Player> players = List.of(new Player("John", "Paul", 25), new Player("Rosy", "Lina", 30));
//        Game game = new Game(board, players);
//        game.play();
//    }
//
//    private BoardConfig setupBoardConfig() {
//        //Ladder Positions
//        List<Position> ladderPositions = List.of(Position.of(4, 25), Position.of(17, 89), Position.of(45, 99));
//        //Snake Positions
//        List<Position> snakePositions = List.of(Position.of(98, 2), Position.of(55, 15), Position.of(76, 14));
//        return new BoardConfig(snakePositions.size(), ladderPositions.size(), snakePositions, ladderPositions);
//    }
//}
