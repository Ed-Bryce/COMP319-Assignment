public class BombPlayerCollisionHandler extends CollisionHandler {
    @Override
    public final void handleCollision(GameObject bomb, GameObject player) {
        if (bomb instanceof Bomb && player instanceof Player) {
            if (checkCollision(bomb, player)) {
                bomb.setActive(false);
                ((Player)player).loseLife();
                soundManager.playPlayerHitSound();
            }
        } else if (successor != null) {
            successor.handleCollision(bomb, player);
        }
    }
    /**
     * BombPlayerCollisionHandler constructor
     * @param scoreBoard active scoreboard instance
     * @param soundManager active soundmanager instance
     */
    public BombPlayerCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}
