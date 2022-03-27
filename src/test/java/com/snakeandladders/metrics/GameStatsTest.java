package com.snakeandladders.metrics;

import com.snakeandladders.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameStatsTest {

    @Test
    void testGameStats() {
        Player player1 = Player.builder().firstName("John").lastName("Cena").age(25).build();
        Player player2 = Player.builder().firstName("Rosy").lastName("Marry").age(30).build();
        List<Player> players = List.of(player1, player2);
        long gameId = 123456L;
        GameStats gameStats = new GameStats(players, gameId);
        gameStats.setBiggestClimb(50);
        gameStats.setBiggestSlide(75);
        gameStats.setLongestTurn(4);
        gameStats.setRollsToWin(12);
        gameStats.setLuckyRolls(20);
        gameStats.setUnluckyRolls(5);
        gameStats.setWinningPlayer(player1);
        assertEquals(gameId, gameStats.getGameId());
        assertEquals(50, gameStats.getBiggestClimb());
        assertEquals(75, gameStats.getBiggestSlide());
        assertEquals(4, gameStats.getLongestTurn());
        assertEquals(12, gameStats.getRollsToWin());
        assertEquals(20, gameStats.getLuckyRolls());
        assertEquals(5, gameStats.getUnluckyRolls());
        assertEquals(player1, gameStats.getWinnerPlayer());
    }
}
