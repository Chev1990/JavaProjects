package org.example;

import java.util.*;

public class ScoreBoard {
    private final Map<String, int[]> games;

    public ScoreBoard() {
        games = new LinkedHashMap<>();
    }

    // Start a game with initial score 0 - 0.
    public void startGame(String homeTeam, String awayTeam) {
        games.put(homeTeam + " - " + awayTeam, new int[]{0, 0});
    }

    // Finish game.It will remove a match from the scoreboard.
    public void finishGame(String homeTeam, String awayTeam) {
        games.remove(homeTeam + " - " + awayTeam);
    }

    // Update score.
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        String key = homeTeam + " - " + awayTeam;
        int[] scores = games.get(key);
        if (scores != null) {
            scores[0] = homeScore;
            scores[1] = awayScore;
        }
    }

    // Sort games by total score and insertion order
    private List<Map.Entry<String, int[]>> sortGames() {
        List<Map.Entry<String, int[]>> sortedGames = new ArrayList<>(games.entrySet());

        sortedGames.sort((g1, g2) -> {
            int[] scores1 = g1.getValue();
            int[] scores2 = g2.getValue();

            int totalScore1 = scores1[0] + scores1[1];
            int totalScore2 = scores2[0] + scores2[1];

            if (totalScore1 != totalScore2) {
                return Integer.compare(totalScore2, totalScore1); // Sort by total score in descending order
            } else {
                return Integer.compare(sortedGames.indexOf(g2), sortedGames.indexOf(g1)); // Sort by insertion order
            }
        });

        return sortedGames;
    }

    // Get summary of games by total score
    public List<String> getSummary() {
        List<String> summary = new ArrayList<>();
        List<Map.Entry<String, int[]>> sortedGames = sortGames();

        for (Map.Entry<String, int[]> game : sortedGames) {
            String teams = game.getKey();
            int[] scores = game.getValue();
            summary.add(teams + ": " + scores[0] + " - " + scores[1]);
        }

        return summary;
    }
}
