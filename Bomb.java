public class Bomb extends GameObject {
    private int gridHeight;

    public Bomb(int x, int y, int width, int height, int gridHeight) {
        super(x, y, 1, 1, 'v');  // Represented by 'v'
        this.gridHeight = gridHeight;
    }

    @Override
    public void update() {
        y += 1;  // Move down
        if (y >= gridHeight) active = false;  // Deactivate if it reaches the bottom
    }

    @Override
    public void render(char[][] grid) {
        if (active) super.render(grid);
    }
}
