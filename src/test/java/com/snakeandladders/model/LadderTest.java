package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    void testCreateLadder() {
        Ladder ladder = new Ladder(2, 40);
        assertEquals(2, ladder.getStartPosition());
        assertEquals(40, ladder.getEndPosition());
        assertEquals("L:2->40", ladder.toString());
    }

}
