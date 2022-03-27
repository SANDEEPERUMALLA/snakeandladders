package com.snakeandladders.metrics;

import com.snakeandladders.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameStatsTest {

    @Test
    void testGameStats() {
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        long gameId = 123456L;
        GameStats gameStats = new GameStats(players, gameId);
    }
}
