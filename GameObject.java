public abstract class GameObject {
    protected int x, y;
    protected int width, height;
    protected char symbol; // Character to represent the object
    protected boolean active = true;

    /**
     * GameObject constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     * @param symbol symbol to represent the object
     */
    public GameObject(int x, int y, int width, int height, char symbol) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    /**
     * Abstract method to include any logic that the gameObject must run each game loop
     */
    public abstract void update();

    /**
     * Adds the gameObject symbol to the correct position in the render grid
     * @param grid the current render grid
     */
    public void render(char[][] grid) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[y + j][x + i] = symbol;
            }
        }
    }

    /**
     * Gets the current state of active
     * @return true or false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the state active for the gameObject
     * @param b boolean
     */
    public void setActive(boolean b) {
        active = b;
    }

    /**
     * Gets the current x coord of the gameObject
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the width of the gameObject
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the current y coord of the gameObject
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the height of the gameObject
     * @return
     */
    public int getHeight() {
        return height;
    }
}
