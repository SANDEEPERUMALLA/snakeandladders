package com.snakeandladders.services;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDice implements Dice {

    @Override public int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }
}
