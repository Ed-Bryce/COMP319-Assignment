public class ScoreBoard {
    private static ScoreBoard instance = new ScoreBoard();
    private int score;

    /**
     * Scoreboard constructor.
     * Sets the current score to 1.
     */
    ScoreBoard() {
        score = 0;
    }

    /**
     * Gets the current ScoreBoard instance
     * @return ScoreBoard instance
     */
    public static ScoreBoard getInstance() {
        return instance;
    }

    /**
     * Increments score count by given integer
     * @param points int, amount to increment score by
     */
    public void addScore(int points) {
        score += points;
    }

    /**
     * Resets the current score to 0
     */
    public void reset() {
        score = 0;
    }

    /**
     * Gets current score value
     * @return int, score
     */
    public int getScore() {
        return score;
    }
}
