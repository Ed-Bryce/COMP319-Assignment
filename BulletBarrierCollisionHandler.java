public class BulletBarrierCollisionHandler extends CollisionHandler {
    @Override
    public final void handleCollision(GameObject bullet, GameObject barrier) {
        if (bullet instanceof Bullet && barrier instanceof Barrier) {
            if (checkCollision(bullet, barrier)) {
                bullet.setActive(false);
                ((Barrier)barrier).takeHit();
                soundManager.playBarrierHitSound();
            }
        } else if (successor != null) {
            successor.handleCollision(bullet, barrier);
        }
    }
    /**
     * BombPlayerCollisionHandler constructor
     * @param scoreBoard active scoreboard instance
     * @param soundManager active soundmanager instance
     */
    public BulletBarrierCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}
