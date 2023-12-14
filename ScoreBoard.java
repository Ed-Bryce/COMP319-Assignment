public class ScoreBoard {
    private static ScoreBoard instance = new ScoreBoard();
    private int score;

    ScoreBoard() {
        score = 0;
    }

    public static ScoreBoard getInstance() {
        return instance;
    }

    public void addScore(int points) {
        score += points;
    }

    public void reset() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    // Additional methods...
}
