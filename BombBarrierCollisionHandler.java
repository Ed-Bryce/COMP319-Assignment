public class BombBarrierCollisionHandler extends CollisionHandler {
    
    
    @Override
    public void handleCollision(GameObject bomb, GameObject barrier) {
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
     * 
     * @param scoreBoard
     */
    public BombBarrierCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}