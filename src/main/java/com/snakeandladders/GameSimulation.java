package com.snakeandladders;

import com.snakeandladders.config.BoardConfig;
import com.snakeandladders.model.*;
import com.snakeandladders.services.*;

import java.util.List;

import static com.snakeandladders.logging.Logger.log;

public class GameSimulation {

    public static void main(String[] args) {
        IBoardConfigGenerator randomBoardConfigGenerator = new RandomBoardConfigGenerator();
        BoardConfig boardConfig = randomBoardConfigGenerator.generate(5, 5);
        log(boardConfig.toString());
        IBoardGenerator configBasedBoardGenerator = new ConfigBasedBoardGenerator(boardConfig);
        Board board = configBasedBoardGenerator.generate();
        board.print();

        List<Player> players = List.of(Player.builder().firstName("John").lastName("Cena").age(25).build(),
                Player.builder().firstName("Rosy").lastName("Marry").age(30).build());
        Game game = new Game(board, players, new RandomDice());
        game.play();
        GameStats stats = game.getStats();
        log("Player Won :" + stats.getWinnerPlayer().getName());
        log("Player Paths");
        log(stats.getPlayerPaths().toString());
        log("Dice History");
        log(stats.getDiceHistory().toString());
    }
}
