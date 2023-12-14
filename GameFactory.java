public class GameFactory {
    public static GameObject createObject(String type, int x, int y, int width, int height, int gridWidth, int gridHeight) {
        if ("Enemy".equals(type)) {
            return new Enemy(x, y, width, height, gridWidth);
        } else if ("Bullet".equals(type)) {
            return new Bullet(x, y, width, height);
        } else if ("Barrier".equals(type)) {
            return new Barrier(x, y, width, height);
        }else if ("Player".equals(type)) {
            return new Player(x, y, width, height, gridWidth);
        }else if ("Bomb".equals(type)) {
            return new Bomb(x, y, width, height, gridHeight);
        }
        return null;
    }
}
