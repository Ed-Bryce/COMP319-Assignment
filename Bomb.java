public class Bomb extends GameObject {
    private int gridHeight;
    
    /**
     * Bomb Constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     * @param gridHeight hight of the game grid
     */
    public Bomb(int x, int y, int width, int height, int gridHeight) {
        super(x, y, 1, 1, 'v');
        this.gridHeight = gridHeight;
    }

    @Override
    public final void update() {
        y += 1;
        if (y >= gridHeight) active = false;
    }

    @Override
    public final void render(char[][] grid) {
        if (active) super.render(grid);
    }
}
