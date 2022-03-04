package com.snakeandladders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.snakeandladders.logging.Logger.log;

public class Game {

    private final Board board;
    private final List<Player> players;
    private final Map<String, Integer> playerPositions;
    private final Map<String, String> playerPaths;
    private final GameStats gameStats;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        playerPositions = new HashMap<>();
        for (Player player : players) {
            playerPositions.put(player.getShortName(), 1);
        }
        playerPaths = new HashMap<>();
        for (Player player : players) {
            playerPaths.put(player.getShortName(), "");
        }
        gameStats = new GameStats(players);

    }

    public void play() {
        boolean gameCompleted = false;

        while (true) {

            for (Player player : players) {
                String playerName = player.getShortName();
                int diceNumber = Dice.rollDice();
                log("Player: " + playerName + ", dice: " + diceNumber);
                Integer playerCurrentPosition = playerPositions.get(playerName);
                int playerNewPosition = playerCurrentPosition + diceNumber;
                if (playerNewPosition > 100) {
                    continue;
                }
                playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
                board.getBoardPosition(playerCurrentPosition).removePlayer(playerName);
                BoardPosition newBoardPosition = board.getBoardPosition(playerNewPosition);

                if (newBoardPosition.hasLadder() || newBoardPosition.hasSnake()) {
                    if (newBoardPosition.hasLadder()) {
                        playerNewPosition = newBoardPosition.getLadder().getEndPosition();
                    }
                    if (newBoardPosition.hasSnake()) {
                        playerNewPosition = newBoardPosition.getSnake().getEndPosition();
                    }
                    if (playerNewPosition > 100) {
                        continue;
                    }
                    playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
                    newBoardPosition = board.getBoardPosition(playerNewPosition);
                    newBoardPosition.addPlayer(playerName);
                } else {
                    newBoardPosition = board.getBoardPosition(playerNewPosition);
                    newBoardPosition.addPlayer(playerName);
                }

                if (playerNewPosition == 100) {
                    gameStats.setPlayerPaths(playerPaths);
                    this.gameStats.setWinningPlayer(player);
                    gameCompleted = true;
                    break;
                }

                playerPositions.put(playerName, playerNewPosition);
                this.board.print();
            }

            if (gameCompleted) {
                break;
            }

        }
    }

    public GameStats getStats() {
        return gameStats;
    }
}
