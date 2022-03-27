package com.snakeandladders.metrics;

import com.snakeandladders.model.AggregatedStats;
import com.snakeandladders.model.GameStats;

import java.util.HashMap;
import java.util.Map;

public class MetricsProcessor implements IMetricsSubscriber {

    Map<Long, GameStats> gameIdToStats;

    public MetricsProcessor() {
        gameIdToStats = new HashMap<>();
    }

    public GameStats getStatsByGameId(long gameId) {
        return gameIdToStats.get(gameId);
    }

    @Override
    public void receive(GameStats gameStats) {
        gameIdToStats.put(gameStats.getGameId(), gameStats);
    }

    public AggregatedStats getAggregatedStats() {
        return new AggregatedStats(gameIdToStats.values());
    }
}
