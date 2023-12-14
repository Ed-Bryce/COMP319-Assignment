public class BombBarrierCollisionHandler extends CollisionHandler {
    
    @Override
    public final void handleCollision(GameObject bomb, GameObject barrier) {
        if (bomb instanceof Bomb && barrier instanceof Barrier) {
            if (checkCollision(bomb, barrier)) {
                bomb.setActive(false);
                ((Barrier)barrier).takeHit();
                soundManager.playBarrierHitSound();
            }
        } else if (successor != null) {
            successor.handleCollision(bomb, barrier);
        }
    }
    /**
     * BombBarrierCollisionHandler constructor
     * @param scoreBoard active scoreboard instance
     * @param soundManager active soundmanager instance
     */
    public BombBarrierCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}