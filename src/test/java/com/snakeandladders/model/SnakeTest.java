package com.snakeandladders.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {

    @Test
    void testCreateSnake() {
        Snake snake = new Snake(2, 40);
        assertEquals(2, snake.getStartPosition());
        assertEquals(40, snake.getEndPosition());
        assertEquals("S:2->40", snake.toString());
    }

    @Test
    void testSnakeEquals() {
        Snake snake1 = new Snake(2, 40);
        Snake snake2 = new Snake(2, 40);
        assertEquals(snake1, snake2);
    }
}
