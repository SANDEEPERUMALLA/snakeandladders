package com.snakeandladders.metrics;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MetricPublisherTest {

    @Test
    void testMetricsPublisher(){
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        IMetricsSubscriber metricsSubscriber = spy(new MetricsProcessor());
        metricsPublisher.register(metricsSubscriber);
        GameStats gameStats = mock(GameStats.class);
        metricsPublisher.publish(gameStats);
        verify(metricsSubscriber, times(1)).receive(gameStats);
    }
}
