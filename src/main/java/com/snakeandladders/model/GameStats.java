package com.snakeandladders.model;

import java.util.List;
import java.util.Map;

public class GameStats {

    private List<Player> players;
    private Player winnerPlayer;
    private Map<String, String> playerPaths;

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
}
