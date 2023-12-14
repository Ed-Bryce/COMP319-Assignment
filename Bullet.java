public class Bullet extends GameObject {
    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height, '^');  // Represented by '^'
    }

    @Override
    public void update() {
        if (y > 0) y -= 1;  // Move up
        else active = false;  // Deactivate the bullet if it reaches the top
    }

    @Override
    public void render(char[][] grid) {
        if (active) super.render(grid);
    }

    // Additional methods...
}
