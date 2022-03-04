package com.snakeandladders.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public static int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, 6);
    }
}
