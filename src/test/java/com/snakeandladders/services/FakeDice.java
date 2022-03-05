package com.snakeandladders.services;

import java.util.List;

public class FakeDice implements Dice {

    private final List<Integer> diceSequence;
    private int current;

    public FakeDice(List<Integer> diceSequence) {
        this.diceSequence = diceSequence;
        current = 0;
    }

    @Override
    public int rollDice() {
        Integer diceNumber = diceSequence.get(current);
        current++;
        return diceNumber;
    }
}
