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
    private int rollsToWin;
    private int unluckyRolls;
    private int luckyRolls;
    private int biggestJump;
    private int biggestSlide;
    private int longestTurn;

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

        while (true) {
            rollsToWin++;
            for (Player player : players) {
                String playerName = player.getShortName();
                int turns = 1;
                int playerPreviousPosition = playerPositions.get(playerName);
                int diceNumber = dice.rollDice();
                diceHistory.add(diceNumber);
                int playerNewPosition = movePlayer(player, diceNumber);
                if (isGameCompleted(playerNewPosition)) {
                    if (playerPositions.get(playerName) == 94) {
                        luckyRolls++;
                    }
                    updateEndGameStats(playerNewPosition, player);
                    return;
                }
                playerPositions.put(playerName, playerNewPosition);
                while (diceNumber == 6) {
                    turns++;
                    diceNumber = dice.rollDice();
                    diceHistory.add(diceNumber);
                    playerNewPosition = movePlayer(player, diceNumber);
                    if (isGameCompleted(playerNewPosition)) {
                        updateEndGameStats(playerNewPosition, player);
                        return;
                    }
                    playerPositions.put(playerName, playerNewPosition);
                }

                if (turns > longestTurn) {
                    longestTurn = turns;
                }
                if (playerNewPosition > playerPreviousPosition) {
                    biggestJump = Math.max(biggestJump, playerNewPosition - playerPreviousPosition);
                }
                if (playerNewPosition < playerPreviousPosition) {
                    biggestSlide = Math.min(biggestSlide, playerNewPosition - playerPreviousPosition);
                }
                this.board.print();
            }

        }
    }

    private void updateEndGameStats(int playerNewPosition, Player player) {
        playerPositions.put(player.getShortName(), playerNewPosition);
        this.gameStats.setWinningPlayer(player);
        this.gameStats.setPlayerPaths(playerPaths);
        this.gameStats.setDiceHistory(diceHistory);
        this.gameStats.setRollsToWin(rollsToWin);
        this.gameStats.setLuckyRolls(luckyRolls);
        this.gameStats.setUnluckyRolls(unluckyRolls);
        this.gameStats.setBiggestClimb(biggestJump);
        this.gameStats.setBiggestSlide(biggestSlide);
        this.gameStats.setLongestTurn(longestTurn);
        this.board.print();
    }

    private boolean isGameCompleted(int playerPosition) {
        return playerPosition == 100;
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
            if (newBoardPosition.hasLadder()) {
                luckyRolls++;
                playerNewPosition = newBoardPosition.getLadder().getEndPosition();
            }
            if (newBoardPosition.hasSnake()) {
                unluckyRolls++;
                playerNewPosition = newBoardPosition.getSnake().getEndPosition();
            }
            playerPaths.put(playerName, playerPaths.get(playerName) + "," + playerNewPosition);
            newBoardPosition = board.getBoardPosition(playerNewPosition);

            if (checkIfPlayerIsLucky(playerNewPosition)) {
                luckyRolls++;
            }

        }

        newBoardPosition.addPlayer(playerName);
        return playerNewPosition;
    }

    private boolean checkIfPlayerIsLucky(int playerPosition) {
        boolean isPlayerLucky = false;
        if (playerPosition - 1 >= 1) {
            isPlayerLucky = board.getBoardPosition(playerPosition - 1).hasSnake();
        } else if (playerPosition - 2 >= 1) {
            isPlayerLucky = board.getBoardPosition(playerPosition - 2).hasSnake();
        } else if (playerPosition + 1 <= 100) {
            isPlayerLucky = board.getBoardPosition(playerPosition + 1).hasSnake();
        } else if (playerPosition + 2 <= 1) {
            isPlayerLucky = board.getBoardPosition(playerPosition + 2).hasSnake();
        }
        return isPlayerLucky;
    }

    public GameStats getStats() {
        return gameStats;
    }

}
