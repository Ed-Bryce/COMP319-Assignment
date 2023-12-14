public class Enemy extends GameObject {
    private boolean movingRight;
    private int gridWidth;

    public Enemy(int x, int y, int width, int height, int gridWidth) {
        super(x, y, width, height, 'E');
        this.movingRight = true;  // Initially moving right
        this.gridWidth = gridWidth;
    }

    @Override
    public void update() {
        if (movingRight) {
            if ((x + width < gridWidth) && (x + width + 3 < gridWidth)) {
                x += 3;
            } else {
                y += 1;  // Move down when reaching the right edge
                movingRight = false;
            }
        } else {
            if (x - 3 > 0) {
                x -= 3;
            } else {
                y += 1;  // Move down when reaching the left edge
                movingRight = true;
            }
        }
    }

    // Additional methods...
}
