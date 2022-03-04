package com.snakeandladders.services;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.model.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomBoardConfigGenerator implements IBoardConfigGenerator {

    @Override public BoardConfig generate(int numOfLadders, int noOfSnakes) {
        return new BoardConfig(generateSnakePositions(noOfSnakes), generateLadderPositions(numOfLadders));
    }

    private List<Position> generateLadderPositions(int requiredLadderCount) {
        List<Position> positions = new ArrayList<>();
        int createdLadderCount = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Set<Integer> ladderPositions = new HashSet<>();
        while (createdLadderCount < requiredLadderCount) {
            int startPosition = random.nextInt(1, 100);
            int endPosition = random.nextInt(startPosition + 1, 100);

            if (ladderPositions.contains(startPosition) || ladderPositions.contains(
                    endPosition) || startPosition == endPosition) {
                continue;
            }

            positions.add(Position.of(startPosition, endPosition));
            ladderPositions.add(startPosition);
            ladderPositions.add(endPosition);
            createdLadderCount++;
        }
        return positions;
    }

    private List<Position> generateSnakePositions(int requiredSnakeCount) {
        List<Position> positions = new ArrayList<>();
        int createdSnakeCount = 0;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Set<Integer> snakePositions = new HashSet<>();
        while (createdSnakeCount < requiredSnakeCount) {
            int startPosition = random.nextInt(1, 100);
            int endPosition = random.nextInt(0, startPosition - 1);

            if (snakePositions.contains(startPosition) || snakePositions.contains(
                    endPosition) || startPosition == endPosition) {
                continue;
            }

            positions.add(Position.of(startPosition, endPosition));
            snakePositions.add(startPosition);
            snakePositions.add(endPosition);
            createdSnakeCount++;
        }
        return positions;
    }

}
