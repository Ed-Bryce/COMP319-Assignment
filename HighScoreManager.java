import java.io.*;

public class HighScoreManager {
    private static HighScoreManager instance = new HighScoreManager();
    private int highScore;
    private String highScoreFile = "highscore.dat";

    private HighScoreManager() {
        highScore = loadHighScore();
    }

    public static HighScoreManager getInstance() {
        return instance;
    }

    private int loadHighScore() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(highScoreFile))) {
            return (int) ois.readObject();
        } catch (Exception e) {
            return 0;
        }
    }

    public void checkAndUpdateHighScore(int currentScore) {
        if (currentScore > highScore) {
            highScore = currentScore;
            saveHighScore();
        }
    }

    private void saveHighScore() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(highScoreFile))) {
            oos.writeObject(highScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getHighScore() {
        return highScore;
    }
}
