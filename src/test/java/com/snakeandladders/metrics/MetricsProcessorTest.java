package com.snakeandladders.metrics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MetricsProcessorTest {

    @Test
    void testMetricProcessor() {
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        GameStatsTest gameStats = mock(GameStatsTest.class);
        long gameId = 123456L;
        when(gameStats.getGameId()).thenReturn(gameId);
        metricsProcessor.receive(gameStats);
        assertEquals(gameStats, metricsProcessor.getStatsByGameId(gameId));
    }

}
