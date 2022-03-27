package com.snakeandladders.metrics;

public interface IMetricsSubscriber {
    void receive(GameStats gameStats);
}
