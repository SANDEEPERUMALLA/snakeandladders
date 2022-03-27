package com.snakeandladders.metrics;

import com.snakeandladders.model.GameStats;

import java.util.ArrayList;
import java.util.List;

public class MetricsPublisher implements IMetricsPublisher {

    private final List<IMetricsSubscriber> metricsSubscribers;

    public MetricsPublisher() {
        metricsSubscribers = new ArrayList<>();
    }

    @Override
    public void register(IMetricsSubscriber metricsSubscriber) {
        metricsSubscribers.add(metricsSubscriber);
    }

    @Override
    public void publish(GameStats gameStats) {
        metricsSubscribers.forEach(ms -> ms.receive(gameStats));
    }
}
