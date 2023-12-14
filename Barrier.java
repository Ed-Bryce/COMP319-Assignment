public class Barrier extends GameObject {
    private int hitCount;
    /**
     * Barrier Constructor
     * @param x x coord
     * @param y y coord
     * @param width object width
     * @param height object height
     */
    public Barrier(int x, int y, int width, int height) {
        super(x, y, width, height, 'B');
        this.hitCount = 0;
    }
    
    @Override
    public final void update() {}

    @Override
    public final void render(char[][] grid) {
        super.render(grid);
    }

    /**
     * Adds a hit to hitCount
     * Sets active to false if hitCount threshold met
     */
    public final void takeHit() {
        hitCount++;
        if (hitCount >= 3) {
            setActive(false); // Deactivate the barrier after 3 hits
        }
    }

}
