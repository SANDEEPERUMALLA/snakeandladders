package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    @Test
    void testCreatePosition() {
        Position position = new Position(1, 25);
        assertEquals(1, position.getStartPosition());
        assertEquals(25, position.getEndPosition());
        assertEquals("(1->25)", position.toString());

        position = Position.of(2, 40);
        assertEquals(2, position.getStartPosition());
        assertEquals(40, position.getEndPosition());
        assertEquals("(2->40)", position.toString());
    }
}
