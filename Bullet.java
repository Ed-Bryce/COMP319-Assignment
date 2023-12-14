public class Bullet extends GameObject {
    /**
     * Bullet constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     */
    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height, '^');
    }

    @Override
    public final void update() {
        if (y > 0) y -= 1;
        else active = false; 
    }

    @Override
    public final void render(char[][] grid) {
        if (active) super.render(grid);
    }

}
