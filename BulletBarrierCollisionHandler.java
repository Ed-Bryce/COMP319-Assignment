public class BulletBarrierCollisionHandler extends CollisionHandler {
    @Override
    public void handleCollision(GameObject bullet, GameObject barrier) {
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

    public BulletBarrierCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}
