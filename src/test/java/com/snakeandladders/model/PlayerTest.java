package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test void testCreatePlayer() {
        Player player = new Player("John", "Paul", 25);
        assertEquals("John", player.getFirstName());
        assertEquals("Paul", player.getLastName());
        assertEquals(25, player.getAge());
        assertEquals("JP", player.getShortName());
        assertEquals("John Paul", player.getName());
    }

    @Test void testCreatePlayerWithNullFirstName() {
        assertThrows(AssertionError.class, () -> new Player(null, "Paul", 25));
    }

    @Test void testCreatePlayerWithNullLastName() {
        assertThrows(AssertionError.class, () -> new Player("John", null, 25));
    }

    @Test void testCreatePlayerWithNullAge() {
        assertThrows(AssertionError.class, () -> new Player("John", "Paul", null));
    }
}
