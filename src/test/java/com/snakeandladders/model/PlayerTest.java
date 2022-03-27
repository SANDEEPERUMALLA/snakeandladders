package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testCreatePlayer() {
        Player player = new Player("John", "Paul", 25);
        assertEquals("John", player.getFirstName());
        assertEquals("Paul", player.getLastName());
        assertEquals(25, player.getAge());
        assertEquals("JP", player.getShortName());
        assertEquals("John Paul", player.getName());
        assertEquals("John Paul", player.toString());
    }

    @Test
    void testCreatePlayerWithNullFirstName() {
        assertThrows(AssertionError.class, () -> new Player(null, "Paul", 25));
    }

    @Test
    void testCreatePlayerWithNullLastName() {
        assertThrows(AssertionError.class, () -> new Player("John", null, 25));
    }

    @Test
    void testCreatePlayerWithNullAge() {
        assertThrows(AssertionError.class, () -> new Player("John", "Paul", null));
    }

    @Test
    void testPlayerEquals() {
        Player player1 = new Player("John", "Paul", 25);
        Player player2 = new Player("John", "Paul", 25);
        assertEquals(player1, player2);
    }
}
