package com.snakeandladders;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.metrics.AggregatedStats;
import com.snakeandladders.metrics.IMetricsPublisher;
import com.snakeandladders.metrics.MetricsProcessor;
import com.snakeandladders.metrics.MetricsPublisher;
import com.snakeandladders.model.*;
import com.snakeandladders.services.*;

import java.util.List;

import static com.snakeandladders.logging.Logger.log;

public class GameSimulation {

    Integer noOfGames;

    public GameSimulation(Integer noOfGames) {
        this.noOfGames = noOfGames;
    }
    public AggregatedStats runSimulation(List<Player> players) {
        IBoardConfigGenerator randomBoardConfigGenerator = new RandomBoardConfigGenerator();
        BoardConfig boardConfig = randomBoardConfigGenerator.generate(5, 5);
        log(boardConfig.toString());
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();
        MetricsProcessor metricsProcessor = new MetricsProcessor();
        IMetricsPublisher metricsPublisher = new MetricsPublisher();
        metricsPublisher.register(metricsProcessor);
        for (int i = 0; i < noOfGames; i++) {
            Game game = new Game(board, players, new RandomDice(), metricsPublisher);
            game.play();
        }
        return metricsProcessor.getAggregatedStats();
    }

    public static void main(String[] args) {
        GameSimulation gameSimulation = new GameSimulation(1);
        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build(),
                Player.builder().firstName("Raj").lastName("Khanna").age(30).build());
        gameSimulation.runSimulation(players);
    }
}
