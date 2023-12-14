public class BulletEnemyCollisionHandler extends CollisionHandler {
    @Override
    public void handleCollision(GameObject bullet, GameObject enemy) {
        if (bullet instanceof Bullet && enemy instanceof Enemy) {
            if (checkCollision(bullet, enemy)) {
                System.out.println("bullet enemy collision");
                bullet.setActive(false);
                enemy.setActive(false);
                scoreBoard.addScore(10);
                soundManager.playEnemyHitSound();
            }
        } else if (successor != null) {
            successor.handleCollision(bullet, enemy);
        }
    }

    public BulletEnemyCollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager) {
        super(scoreBoard, soundManager);
    }
}