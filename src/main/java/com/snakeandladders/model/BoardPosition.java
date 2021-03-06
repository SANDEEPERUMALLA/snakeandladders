package com.snakeandladders.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BoardPosition {
    private final Integer position;
    private final List<String> players;
    private Snake snake;
    private Ladder ladder;

    public BoardPosition(Integer position) {
        if (position == null) {
            throw new AssertionError();
        }
        players = new ArrayList<>();
        this.position = position;
    }

    public boolean hasSnake() {
        return snake != null && position == snake.getStartPosition();
    }

    public boolean hasLadder() {
        return ladder != null && position == ladder.getStartPosition();
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public Snake getSnake() {
        return snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public boolean addPlayer(String player) {
        return players.add(player);
    }

    public boolean removePlayer(String player) {
        return players.remove(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BoardPosition that = (BoardPosition)o;
        return Objects.equals(position, that.position) && Objects.equals(players, that.players) && Objects.equals(snake,
                that.snake) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, players, snake, ladder);
    }

    @Override
    public String toString() {
        StringBuilder boardPosition = new StringBuilder();
        boardPosition.append("[");
        boardPosition.append("(").append(position).append(")");

        if (players != null && !players.isEmpty()) {
            boardPosition.append("(");
            for (String player : players) {
                boardPosition.append(player).append(",");
            }
            boardPosition.append(")");
        }

        if (snake != null) {
            boardPosition.append("(").append(snake).append(")");
        }

        if (ladder != null) {
            boardPosition.append("(").append(ladder).append(")");
        }

        boardPosition.append("]");
        return boardPosition.toString();
    }
}
