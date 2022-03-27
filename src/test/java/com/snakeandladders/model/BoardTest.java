package com.snakeandladders.model;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.services.ConfigBasedBoardGenerator;
import com.snakeandladders.services.IBoardGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testBoardCreation() {
        //Snake Positions
        List<Position> snakePositions = List.of(Position.of(45, 5), Position.of(31, 10), Position.of(89, 3),
                Position.of(82, 34), Position.of(63, 61));

        // Ladder Positions
        List<Position> ladderPositions = List.of(Position.of(90, 94), Position.of(74, 82), Position.of(60, 75),
                Position.of(1, 84), Position.of(16, 33));

        BoardConfig boardConfig = new BoardConfig(snakePositions, ladderPositions);
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        System.out.println("Board");
        String expectedBoardState = "[(91)] [(92)] [(93)] [(94)(L:90->94)] [(95)] [(96)] [(97)] [(98)] [(99)] [(100)]\n" + "[(81)] [(82)(S:82->34)(L:74->82)] [(83)] [(84)(L:1->84)] [(85)] [(86)] [(87)] [(88)] [(89)(S:89->3)] [(90)(L:90->94)]\n" + "[(71)] [(72)] [(73)] [(74)(L:74->82)] [(75)(L:60->75)] [(76)] [(77)] [(78)] [(79)] [(80)]\n" + "[(61)(S:63->61)] [(62)] [(63)(S:63->61)] [(64)] [(65)] [(66)] [(67)] [(68)] [(69)] [(70)]\n" + "[(51)] [(52)] [(53)] [(54)] [(55)] [(56)] [(57)] [(58)] [(59)] [(60)(L:60->75)]\n" + "[(41)] [(42)] [(43)] [(44)] [(45)(S:45->5)] [(46)] [(47)] [(48)] [(49)] [(50)]\n" + "[(31)(S:31->10)] [(32)] [(33)(L:16->33)] [(34)(S:82->34)] [(35)] [(36)] [(37)] [(38)] [(39)] [(40)]\n" + "[(21)] [(22)] [(23)] [(24)] [(25)] [(26)] [(27)] [(28)] [(29)] [(30)]\n" + "[(11)] [(12)] [(13)] [(14)] [(15)] [(16)(L:16->33)] [(17)] [(18)] [(19)] [(20)]\n" + "[(1)(L:1->84)] [(2)] [(3)(S:89->3)] [(4)] [(5)(S:45->5)] [(6)] [(7)] [(8)] [(9)] [(10)(S:31->10)]\n";
        assertEquals(expectedBoardState, board.toString());
        assertTrue(board.getBoardPosition(45).hasSnake());
        assertTrue(board.getBoardPosition(31).hasSnake());
        assertTrue(board.getBoardPosition(89).hasSnake());
        assertTrue(board.getBoardPosition(82).hasSnake());
        assertTrue(board.getBoardPosition(63).hasSnake());

        assertTrue(board.getBoardPosition(90).hasLadder());
        assertTrue(board.getBoardPosition(74).hasLadder());
        assertTrue(board.getBoardPosition(60).hasLadder());
        assertTrue(board.getBoardPosition(1).hasLadder());
        assertTrue(board.getBoardPosition(16).hasLadder());
    }

    @Test
    void testCreateBoardWithInCorrectBoardPositions(){
        assertThrows(AssertionError.class, () -> {
            BoardPosition[] boardPositions = new BoardPosition[0];
            new Board(boardPositions);
        });
    }
}
