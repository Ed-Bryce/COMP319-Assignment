public class BombPlayerCollisionHandler extends CollisionHandler {
    @Override
    public void handleCollision(GameObject bomb, GameObject player) {
        if (bomb instanceof Bomb && player instanceof Player) {
            if (checkCollision(bomb, player)) {
                bomb.setActive(false);
                ((Player)player).loseLife();
            }
        } else if (successor != null) {
            successor.handleCollision(bomb, player);
        }
    }

    public BombPlayerCollisionHandler(ScoreBoard scoreBoard) {
        super(scoreBoard);
    }
}
