import java.io.*;

public class HighScoreManager {
    private static HighScoreManager instance = new HighScoreManager();
    private int highScore;
    private String highScoreFile = "highscore.dat";

    /**
     * HighScoreManager constructor.
     * Calls loadHighScore(); function on creation.
     */
    private HighScoreManager() {
        highScore = loadHighScore();
    }

    /**
     * Gets the instance of HighScore manager
     * @return HighScoreManager
     */
    public static HighScoreManager getInstance() {
        return instance;
    }

    /**
     * Loads curent high score from a .dat file.
     * @return int, current high score
     */
    private int loadHighScore() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(highScoreFile))) {
            return (int) ois.readObject();
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Checks if current score is greater than the loaded highscore.
     * If true then saves current score as the high score.
     * @param currentScore int, current score from end of game
     */
    public void checkAndUpdateHighScore(int currentScore) {
        if (currentScore > highScore) {
            highScore = currentScore;
            saveHighScore();
        }
    }

    /**
     * Saves the current high score to a .dat file.
     */
    private void saveHighScore() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(highScoreFile))) {
            oos.writeObject(highScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the loaded high score
     * @return int, high score
     */
    public int getHighScore() {
        return highScore;
    }
}
