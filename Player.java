public class Player extends GameObject {
    private int gridWidth;
    private int lives;

    /**
     * Player Constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     * @param gridHeight hight of the game grid
     */
    public Player(int x, int y, int width, int height, int gridWidth) {
        super(x, y, width, height, 'P');
        this.gridWidth = gridWidth;
        this.lives = 3;
    }

    /**
     * Reduces life count by 1
     */
    public final void loseLife() {
        lives--;
    }

    /**
     * Gets current amount of lives
     * @return int, current lives
     */
    public final int getLives() {
        return lives;
    }

    /**
     * Moves the player left by 1
     */
    public final void moveLeft() {
        x = Math.max(0, x - 1);
    }

    /**
     * Moves the player right by 1
     */
    public final void moveRight() {
        x = Math.min(gridWidth - width, x + 1);
    }

    /**
     * Gets the current x coord
     * @return int, x coord
     */
    public final int getX(){
        return x;
    }

    /**
     * Gets the current y coord
     * @return int, y coord
     */
    public final int getY(){
        return y;
    }

    @Override
    public final void update() {}

    @Override
    public final void render(char[][] grid) {
        super.render(grid);
    }
}
