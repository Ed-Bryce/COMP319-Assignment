public class BulletEnemyCollisionHandler extends CollisionHandler {
    @Override
    public final void handleCollision(GameObject bullet, GameObject enemy) {
        if (bullet instanceof Bullet && enemy instanceof Enemy) {
            if (checkCollision(bullet, enemy)) {
                bullet.setActive(false);
                enemy.setActive(false);
                scoreBoard.addScore(10);
                soundManager.playEnemyHitSound();
            }
        } else if (successor != null) {
            successor.handleCollision(bullet, enemy);
        }
    }
    /**
     * BulletEnemyCollisionHandler constructor
     * @param scoreBoard active scoreboard instance
     * @param soundManager active soundmanager instance
     */
    public BulletEnemyCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}