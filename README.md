This code is a ScoreBoard class that implements a soccer scoreboard. Here is a step by step explanation of each part of it:
 - Class declaration and its variables:
Map<String, int[]> games: Stores information about the current games, where the key is string in the format "Team1 - Team2" and value is array of two elements representing score of  game.
 - Class constructor:
Creates empty ScoreBoard object and initializes variable with empty ordered map (LinkedHashMap) to save order in which games are added.
 - Methods of class:
   - startGame: Starts new game, initializing score to 0 - 0 and adding game to games.
   - finishGame: Ends game and removes it from games. 
   - updateScore: Updates game score by finding the corresponding game in games by key and updating score. 
   - sortGames: A private method that sorts games in games by total score and adding order. 
   - getSummary: returns summary of games by total score as list of strings, sorted using sortGames. 
   - main method:
shows how to use ScoreBoard to start games, update scores, and get game summaries.
A scoreboard object of the ScoreBoard class is created.
Summary of the games is obtained using the getSummary method, and the results are printed to the console.

Tests are in test/java/org/example.
