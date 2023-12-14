public class BombBarrierCollisionHandler extends CollisionHandler {
    @Override
    public void handleCollision(GameObject bomb, GameObject barrier) {
        if (bomb instanceof Bomb && barrier instanceof Barrier) {
            if (checkCollision(bomb, barrier)) {
                bomb.setActive(false);
                ((Barrier)barrier).takeHit();
            }
        } else if (successor != null) {
            successor.handleCollision(bomb, barrier);
        }
    }

    public BombBarrierCollisionHandler(ScoreBoard scoreBoard) {
        super(scoreBoard);
    }
}