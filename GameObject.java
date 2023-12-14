public abstract class GameObject {
    protected int x, y;
    protected int width, height;
    protected char symbol; // Character to represent the object
    protected boolean active = true;

    public boolean isActive() {
        return active;
    }

    public GameObject(int x, int y, int width, int height, char symbol) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    public abstract void update();

    public void render(char[][] grid) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[y + j][x + i] = symbol;
            }
        }
    }

    public void setActive(boolean b) {
        active = b;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }
}
