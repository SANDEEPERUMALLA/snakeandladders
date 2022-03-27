package com.snakeandladders.metrics;

public interface IMetricsPublisher {
    void register(IMetricsSubscriber metricsSubscriber);
    void publish(GameStats gameStats);
}
