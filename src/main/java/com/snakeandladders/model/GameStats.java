package com.snakeandladders.model;

import java.util.List;
import java.util.Map;

public class GameStats {

    private final List<Player> players;
    private Player winnerPlayer;
    private Map<String, String> playerPaths;
    private List<Integer> diceHistory;
    private int rollsToWin;
    private int biggestClimb;
    private int biggestSlide;
    private int luckyRolls;
    private int unluckyRolls;
    private int longestTurn;

    public List<Integer> getDiceHistory() {
        return diceHistory;
    }

    public void setDiceHistory(List<Integer> diceHistory) {
        this.diceHistory = diceHistory;
    }

    public GameStats(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map<String, String> getPlayerPaths() {
        return playerPaths;
    }

    public void setPlayerPaths(Map<String, String> playerPaths) {
        this.playerPaths = playerPaths;
    }

    public void setWinningPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public int getRollsToWin() {
        return rollsToWin;
    }

    public void setRollsToWin(int rollsToWin) {
        this.rollsToWin = rollsToWin;
    }

    public int getBiggestClimb() {
        return biggestClimb;
    }

    public void setBiggestClimb(int biggestClimb) {
        this.biggestClimb = biggestClimb;
    }

    public int getBiggestSlide() {
        return biggestSlide;
    }

    public void setBiggestSlide(int biggestSlide) {
        this.biggestSlide = biggestSlide;
    }

    public int getLuckyRolls() {
        return luckyRolls;
    }

    public void setLuckyRolls(int luckyRolls) {
        this.luckyRolls = luckyRolls;
    }

    public int getUnluckyRolls() {
        return unluckyRolls;
    }

    public void setUnluckyRolls(int unluckyRolls) {
        this.unluckyRolls = unluckyRolls;
    }

    public int getLongestTurn() {
        return longestTurn;
    }

    public void setLongestTurn(int longestTurn) {
        this.longestTurn = longestTurn;
    }

    @Override public String toString() {
        return "GameStats{" + "players=" + players + ", winnerPlayer=" + winnerPlayer + ", playerPaths=" + playerPaths + ", diceHistory=" + diceHistory + ", rollsToWin=" + rollsToWin + ", biggestClimb=" + biggestClimb + ", biggestSlide=" + biggestSlide + ", luckyRolls=" + luckyRolls + ", unluckyRolls=" + unluckyRolls + ", longestTurn=" + longestTurn + '}';
    }
}
