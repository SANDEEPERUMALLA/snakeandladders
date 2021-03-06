package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardPositionTest {

    @Test
    void testCreateBoardPositionWithSinglePlayer(){
        BoardPosition boardPosition = new BoardPosition(10);
        boardPosition.addPlayer("A");
        System.out.println(boardPosition.toString());
        assertEquals("[(10)(A,)]", boardPosition.toString());
    }

    @Test
    void testCreateBoardPositionWithTwoPlayers(){
        BoardPosition boardPosition = new BoardPosition(10);
        boardPosition.addPlayer("A");
        boardPosition.addPlayer("B");
        System.out.println(boardPosition.toString());
        assertEquals("[(10)(A,B,)]", boardPosition.toString());
    }

    @Test
    void testCreateBoardPositionWithLadder(){
        BoardPosition boardPosition = new BoardPosition(10);
        boardPosition.addPlayer("A");
        boardPosition.addPlayer("B");
        boardPosition.setLadder(new Ladder(10, 50));
        System.out.println(boardPosition.toString());
        assertEquals("[(10)(A,B,)(L:10->50)]", boardPosition.toString());
        assertTrue(boardPosition.hasLadder());
        assertFalse(boardPosition.hasSnake());
    }

    @Test
    void testCreateBoardPositionWithSnake(){
        BoardPosition boardPosition = new BoardPosition(50);
        boardPosition.addPlayer("A");
        boardPosition.addPlayer("B");
        boardPosition.setSnake(new Snake(50, 10));
        assertEquals("[(50)(A,B,)(S:50->10)]", boardPosition.toString());
        assertTrue(boardPosition.hasSnake());
        assertFalse(boardPosition.hasLadder());
    }

    @Test
    void testCreateBoardPositionWithNull(){
        assertThrows(AssertionError.class, () -> new BoardPosition(null));
    }

    @Test
    void testBoardPositionEquals(){
        BoardPosition boardPosition1 = new BoardPosition(50);
        boardPosition1.addPlayer("A");
        boardPosition1.addPlayer("B");
        boardPosition1.setSnake(new Snake(50, 10));

        BoardPosition boardPosition2 = new BoardPosition(50);
        boardPosition2.addPlayer("A");
        boardPosition2.addPlayer("B");
        boardPosition2.setSnake(new Snake(50, 10));
        assertEquals(boardPosition1, boardPosition2);
    }
}
