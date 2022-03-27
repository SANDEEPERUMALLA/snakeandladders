package com.snakeandladders.metrics;

import com.snakeandladders.model.GameStats;

public interface IMetricsSubscriber {
    void receive(GameStats gameStats);
}
