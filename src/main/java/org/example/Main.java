package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ScoreBoard scoreboard = new ScoreBoard();

        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateScore("Mexico", "Canada", 0, 5);

        scoreboard.startGame("Spain", "Brazil");
        scoreboard.updateScore("Spain", "Brazil", 10, 2);

        scoreboard.startGame("Germany", "France");
        scoreboard.updateScore("Germany", "France", 2, 2);

        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.updateScore("Uruguay", "Italy", 6, 6);

        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<String> summary = scoreboard.getSummary();
        for (String game : summary) {
            System.out.println(game);
        }
    }
}