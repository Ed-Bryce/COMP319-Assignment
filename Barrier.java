public class Barrier extends GameObject {
    private int hitCount;

    public Barrier(int x, int y, int width, int height) {
        super(x, y, width, height, 'B');
        this.hitCount = 0;
    }

    @Override
    public void update() {}

    @Override
    public void render(char[][] grid) {
        super.render(grid);
    }

    public void takeHit() {
        hitCount++;
        if (hitCount >= 3) {
            setActive(false); // Deactivate the barrier after 3 hits
        }
    }

}
