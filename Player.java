public class Player extends GameObject {
    // Player-specific attributes...
    private int gridWidth;
    private int lives;

    public Player(int x, int y, int width, int height, int gridWidth) {
        super(x, y, width, height, 'P');  // 'P' to represent the Player
        this.gridWidth = gridWidth;
        this.lives = 3;
    }

    public void loseLife() {
        lives--;
    }

    public int getLives() {
        return lives;
    }

    public void moveLeft() {
        x = Math.max(0, x - 1);
    }

    public void moveRight() {
        x = Math.min(gridWidth - width, x + 1);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public void update() {}

    @Override
    public void render(char[][] grid) {
        super.render(grid);
    }

    // Additional methods...
}
