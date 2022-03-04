package com.snakeandladders.services;

import com.snakeandladders.config.BoardConfig;

public interface IBoardConfigGenerator {
    BoardConfig generate(int numOfLadders, int noOfSnakes);
}
