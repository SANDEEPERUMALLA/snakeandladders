package com.snakeandladders.services;

import com.snakeandladders.config.BoardConfig;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomBoardConfigGeneratorTest {

    @Test
    void testRandomBoardConfigGeneration() {
        RandomBoardConfigGenerator randomBoardConfigGenerator = new RandomBoardConfigGenerator();
        BoardConfig boardConfig = randomBoardConfigGenerator.generate(6, 8);
        assertEquals(6, boardConfig.getLadderPositions().size());
        assertEquals(8, boardConfig.getSnakePositions().size());
    }
}
