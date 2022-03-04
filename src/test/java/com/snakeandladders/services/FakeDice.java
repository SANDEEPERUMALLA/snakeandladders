package com.snakeandladders.services;

import java.util.List;

public class FakeDice implements Dice {

    private final List<Integer> diceNumbers;
    private int current;

    public FakeDice(List<Integer> diceNumbers) {
        this.diceNumbers = diceNumbers;
        current = 0;
    }

    @Override public int rollDice() {
        Integer diceNumber = diceNumbers.get(current);
        current++;
        return diceNumber;
    }
}
