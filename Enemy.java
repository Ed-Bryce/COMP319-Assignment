public class Enemy extends GameObject {
    private boolean movingRight;
    private int gridWidth;

    /**
     * Enemy (Alien/UFO) Constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     * @param gridHeight hight of the game grid
     */
    public Enemy(int x, int y, int width, int height, int gridWidth) {
        super(x, y, width, height, 'E');
        this.movingRight = true;
        this.gridWidth = gridWidth;
    }

    @Override
    public final void update() {
        if (movingRight) {
            if ((x + width < gridWidth) && (x + width + 3 < gridWidth)) {
                x += 3;
            } else {
                y += 1;
                movingRight = false;
            }
        } else {
            if (x - 3 > 0) {
                x -= 3;
            } else {
                y += 1;
                movingRight = true;
            }
        }
    }
}
