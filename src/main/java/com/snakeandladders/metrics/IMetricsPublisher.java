package com.snakeandladders.metrics;

import com.snakeandladders.model.GameStats;

public interface IMetricsPublisher {
    void register(IMetricsSubscriber metricsSubscriber);
    void publish(GameStats gameStats);
}
