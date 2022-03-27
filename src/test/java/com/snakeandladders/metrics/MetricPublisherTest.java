package com.snakeandladders.metrics;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MetricPublisherTest {

    @Test
    void testMetricsPublisher(){
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        IMetricsSubscriber metricsSubscriber1 = spy(new MetricsProcessor());
        IMetricsSubscriber metricsSubscriber2 = spy(new MockTestSubscriber());
        metricsPublisher.register(metricsSubscriber1);
        metricsPublisher.register(metricsSubscriber2);
        GameStatsTest gameStats = mock(GameStatsTest.class);
        metricsPublisher.publish(gameStats);
        verify(metricsSubscriber1, times(1)).receive(gameStats);
        verify(metricsSubscriber2, times(1)).receive(gameStats);
    }

    private static class MockTestSubscriber implements IMetricsSubscriber {
        @Override
        public void receive(GameStatsTest gameStats) {

        }
    }
}
