package com.snakeandladders.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomDiceTest {

    @Test
    void testRandomDice() {
        RandomDice randomDice = new RandomDice();
        int diceNumber = randomDice.rollDice();
        assertTrue(diceNumber >= 1 && diceNumber < 7);
        diceNumber = randomDice.rollDice();
        assertTrue(diceNumber >= 1 && diceNumber < 7);
        diceNumber = randomDice.rollDice();
        assertTrue(diceNumber >= 1 && diceNumber < 7);
    }
}
