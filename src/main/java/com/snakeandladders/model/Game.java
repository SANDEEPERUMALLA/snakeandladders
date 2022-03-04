package com.snakeandladders.model;

import com.snakeandladders.services.Dice;

import java.util.*;

import static com.snakeandladders.logging.Logger.log;

public class Game {

    private final Board board;
    private final List<Player> players;
    private final Map<String, Integer> playerPositions;
    private final Map<String, String> playerPaths;
    private final GameStats gameStats;
    private final Dice dice;
    private final List<Integer> diceHistory;

    public Game(Board board, List<Player> players, Dice dice) {
        this.board = board;
        this.players = players;
        this.dice = dice;
        playerPositions = new HashMap<>();
        for (Player player : players) {
            playerPositions.put(player.getShortName(), 1);
        }
        playerPaths = new HashMap<>();
        for (Player player : players) {
            playerPaths.put(player.getShortName(), "");
        }
        gameStats = new GameStats(players);
        diceHistory = new ArrayList<>();
    }

    public void play() {
        boolean gameCompleted = false;

        while (true) {

            for (Player player : players) {
                String playerName = player.getShortName();
                int diceNumber = dice.rollDice();
                diceHistory.add(diceNumber);
                //                log("Player: " + playerName + ", dice: " + diceNumber);
                //                Integer playerCurrentPosition = playerPositions.get(playerName);
                //                int playerNewPosition = playerCurrentPosition + diceNumber;
                //                if (playerNewPosition > 100) {
                //                    continue;
                //                }
                //                playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
                //                board.getBoardPosition(playerCurrentPosition).removePlayer(playerName);
                //                BoardPosition newBoardPosition = board.getBoardPosition(playerNewPosition);
                //
                //                while (newBoardPosition.hasLadder() || newBoardPosition.hasSnake()) {
                //                    if (newBoardPosition.hasLadder() || newBoardPosition.hasSnake()) {
                //                        if (newBoardPosition.hasLadder()) {
                //                            playerNewPosition = newBoardPosition.getLadder().getEndPosition();
                //                        }
                //                        if (newBoardPosition.hasSnake()) {
                //                            playerNewPosition = newBoardPosition.getSnake().getEndPosition();
                //                        }
                //                        playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
                //                        newBoardPosition = board.getBoardPosition(playerNewPosition);
                //                    }
                //                }
                //
                //                newBoardPosition.addPlayer(playerName);
                int playerNewPosition = movePlayer(player, diceNumber);
                if (hasGameCompleted(playerNewPosition, player)) {
                    gameCompleted = true;
                    break;
                }
                playerPositions.put(playerName, playerNewPosition);
                while (diceNumber == 6) {
                    playerNewPosition = movePlayer(player, diceNumber);
                    if (hasGameCompleted(playerNewPosition, player)) {
                        gameCompleted = true;
                        break;
                    }
                    playerPositions.put(playerName, playerNewPosition);
                    diceNumber = dice.rollDice();
                    diceHistory.add(diceNumber);
                }
                this.board.print();
            }

            if (gameCompleted) {
                break;
            }

        }
    }

    private boolean hasGameCompleted(int playerNewPosition, Player player) {
        if (playerNewPosition == 100) {
            playerPositions.put(player.getShortName(), playerNewPosition);
            this.gameStats.setWinningPlayer(player);
            this.gameStats.setPlayerPaths(playerPaths);
            this.gameStats.setDiceHistory(diceHistory);
            this.board.print();
            return true;
        }
        return false;
    }

    private int movePlayer(Player player, int diceNumber) {
        String playerName = player.getShortName();
        log("Player: " + playerName + ", dice: " + diceNumber);
        Integer playerCurrentPosition = playerPositions.get(playerName);
        int playerNewPosition = playerCurrentPosition + diceNumber;
        if (playerNewPosition > 100) {
            return playerCurrentPosition;
        }
        playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
        board.getBoardPosition(playerCurrentPosition).removePlayer(playerName);
        BoardPosition newBoardPosition = board.getBoardPosition(playerNewPosition);

        while (newBoardPosition.hasLadder() || newBoardPosition.hasSnake()) {
            if (newBoardPosition.hasLadder() || newBoardPosition.hasSnake()) {
                if (newBoardPosition.hasLadder()) {
                    playerNewPosition = newBoardPosition.getLadder().getEndPosition();
                }
                if (newBoardPosition.hasSnake()) {
                    playerNewPosition = newBoardPosition.getSnake().getEndPosition();
                }
                playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
                newBoardPosition = board.getBoardPosition(playerNewPosition);
            }
        }

        newBoardPosition.addPlayer(playerName);
        return playerNewPosition;
    }

    public GameStats getStats() {
        return gameStats;
    }
}
