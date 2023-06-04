package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ScoreBoardTest {
    private ScoreBoard scoreboard;

    @BeforeEach
    public void setUp() {
        scoreboard = new ScoreBoard();
    }

    @Test
    public void testStartGame() {
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.startGame("Spain", "Brazil");

        List<String> summary = scoreboard.getSummary();

        Assertions.assertEquals(2, summary.size());
        Assertions.assertTrue(summary.contains("Mexico - Canada: 0 - 0"));
        Assertions.assertTrue(summary.contains("Spain - Brazil: 0 - 0"));
    }

    @Test
    public void testFinishGame() {
        scoreboard.startGame("Germany", "France");
        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.finishGame("Germany", "France");

        List<String> summary = scoreboard.getSummary();

        Assertions.assertEquals(1, summary.size());
        Assertions.assertTrue(summary.contains("Uruguay - Italy: 0 - 0"));
        Assertions.assertFalse(summary.contains("Germany - France: 0 - 0"));
    }

    @Test
    public void testUpdateScore() {
        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateScore("Argentina", "Australia", 3, 1);

        List<String> summary = scoreboard.getSummary();

        Assertions.assertEquals(1, summary.size());
        Assertions.assertTrue(summary.contains("Argentina - Australia: 3 - 1"));
    }

    @Test
    public void testGetSummary() {
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

        Assertions.assertEquals(5, summary.size());
        Assertions.assertEquals("Uruguay - Italy: 6 - 6", summary.get(0));
        Assertions.assertEquals("Spain - Brazil: 10 - 2", summary.get(1));
        Assertions.assertEquals("Mexico - Canada: 0 - 5", summary.get(2));
        Assertions.assertEquals("Argentina - Australia: 3 - 1", summary.get(3));
        Assertions.assertEquals("Germany - France: 2 - 2", summary.get(4));
    }
}
