package com.snakeandladders.model;

import java.util.Collection;
import java.util.IntSummaryStatistics;

public class AggregatedStats {

    private int maxRollsToWin;
    private int minRollsToWin;
    private double avgRollsToWin;
    private int biggestClimb;
    private int biggestSlide;
    private int maxLuckyRolls;
    private int minLuckyRolls;
    private double averageLuckyRolls;
    private int maxUnluckyRolls;
    private int minUnluckyRolls;
    private double averageUnluckyRolls;
    private int longestTurn;

    public AggregatedStats(Collection<GameStats> gameStatsList) {
        aggregate(gameStatsList);
    }

    public void aggregate(Collection<GameStats> gameStatsList) {
        IntSummaryStatistics statistics = gameStatsList.stream().mapToInt(GameStats::getRollsToWin).summaryStatistics();

        // Rolls to win
        maxRollsToWin = statistics.getMax();
        minRollsToWin = statistics.getMin();
        avgRollsToWin = statistics.getAverage();

        // Jumps and Slide
        biggestClimb = gameStatsList.stream().mapToInt(GameStats::getBiggestClimb).summaryStatistics().getMax();
        biggestSlide = gameStatsList.stream().mapToInt(GameStats::getBiggestSlide).summaryStatistics().getMax();
        longestTurn = gameStatsList.stream().mapToInt(GameStats::getLongestTurn).summaryStatistics().getMax();

        // Lucky rolls
        statistics = gameStatsList.stream().mapToInt(GameStats::getLuckyRolls).summaryStatistics();

        maxLuckyRolls = statistics.getMax();
        minLuckyRolls = statistics.getMin();
        averageLuckyRolls = statistics.getAverage();

        // Unlucky rolls
        statistics = gameStatsList.stream().mapToInt(GameStats::getUnluckyRolls).summaryStatistics();

        maxUnluckyRolls = statistics.getMax();
        minUnluckyRolls = statistics.getMin();
        averageUnluckyRolls = statistics.getAverage();
    }

    public int getMaxRollsToWin() {
        return maxRollsToWin;
    }

    public int getMinRollsToWin() {
        return minRollsToWin;
    }

    public double getAvgRollsToWin() {
        return avgRollsToWin;
    }

    public int getBiggestClimb() {
        return biggestClimb;
    }

    public int getBiggestSlide() {
        return biggestSlide;
    }

    public int getMaxLuckyRolls() {
        return maxLuckyRolls;
    }

    public int getMinLuckyRolls() {
        return minLuckyRolls;
    }

    public double getAverageLuckyRolls() {
        return averageLuckyRolls;
    }

    public int getMaxUnluckyRolls() {
        return maxUnluckyRolls;
    }

    public int getMinUnluckyRolls() {
        return minUnluckyRolls;
    }

    public double getAverageUnluckyRolls() {
        return averageUnluckyRolls;
    }

    public int getLongestTurn() {
        return longestTurn;
    }

    @Override
    public String toString() {
        return "AggregatedStats{" + "maxRollsToWin=" + maxRollsToWin + ", minRollsToWin=" + minRollsToWin + ", avgRollsToWin=" + avgRollsToWin + ", biggestClimb=" + biggestClimb + ", biggestSlide=" + biggestSlide + ", maxLuckyRolls=" + maxLuckyRolls + ", minLuckyRolls=" + minLuckyRolls + ", averageLuckyRolls=" + averageLuckyRolls + ", maxUnluckyRolls=" + maxUnluckyRolls + ", minUnluckyRolls=" + minUnluckyRolls + ", averageUnluckyRolls=" + averageUnluckyRolls + ", longestTurn=" + longestTurn + '}';
    }
}


