package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    void testCreateLadder() {
        Ladder ladder = new Ladder(2, 40);
        assertEquals(2, ladder.getStartPosition());
        assertEquals(40, ladder.getEndPosition());
        assertEquals("L:2->40", ladder.toString());
    }

    @Test
    void testLadderEquals() {
        Ladder ladder1 = new Ladder(2, 40);
        Ladder ladder2 = new Ladder(2, 40);
        assertEquals(ladder1, ladder2);
    }

}
