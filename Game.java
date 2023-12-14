import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private static Game instance = new Game();
    private boolean running;
    private char[][] grid;
    private final int gridWidth = 30;
    private final int gridHeight = 15;
    private List<Enemy> enemies;
    private Player player;
    private List<Barrier> barriers;
    private List<Bullet> bullets;
    private List<Bomb> bombs;
    private CollisionHandler collisionChain;
    private ScoreBoard scoreBoard;
    private Random random;

    private Game() {
        running = true;
        grid = new char[gridHeight][gridWidth];
        enemies = new ArrayList<>();
        bullets = new ArrayList<>();
        bombs = new ArrayList<>();
        scoreBoard = new ScoreBoard();
        random = new Random();
        initializeEnemies();
        player = (Player) GameFactory.createObject("Player", gridWidth / 2, gridHeight - 2, 1, 1, gridWidth, gridHeight);
        initializeBarriers();
        initializeCollisionChain();
    }

    private boolean checkGameOver() {
        int barrierLevel = barriers.get(0).getY();
        for (Enemy enemy : enemies) {
            if (enemy.isActive() && enemy.getY() >= barrierLevel) {
                return true;
            }
        }
        if(player.getLives() <= 0){
            return true;
        }
        return false;
    }

    public static Game getInstance() {
        return instance;
    }

    private void initializeEnemies() {
        enemies.clear();
        for (int i = 0; i < 5; i++) {
            Enemy enemy = (Enemy) GameFactory.createObject("Enemy", 6 * i, 1, 1, 1, gridWidth, gridHeight);
            enemies.add(enemy);
        }
    }

    private void initializeBarriers() {
        barriers = new ArrayList<>();
        int barrierSpacing = gridWidth / 5;
        for (int i = 1; i <= 4; i++) {
            barriers.add(new Barrier(i * barrierSpacing - barrierSpacing / 2, gridHeight - 5, 2, 2));
        }
    }

    private void initializeCollisionChain() {
        collisionChain = new BulletEnemyCollisionHandler(scoreBoard);
        CollisionHandler bulletBarrierHandler = new BulletBarrierCollisionHandler(scoreBoard);
        CollisionHandler bombBarrierHandler = new BombBarrierCollisionHandler(scoreBoard);
        CollisionHandler bombPlayerHandler = new BombPlayerCollisionHandler(scoreBoard);
        collisionChain.setSuccessor(bulletBarrierHandler);
        bulletBarrierHandler.setSuccessor(bombBarrierHandler);
        bombBarrierHandler.setSuccessor(bombPlayerHandler);
    }

    private boolean areAllEnemiesInactive() {
        for (Enemy enemy : enemies) {
            if (enemy.isActive()) {
                return false;
            }
        }
        return true;
    }

    private void clearGrid() {
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    private void renderGrid() {
        System.out.println("        SPACE INVADERS\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Score: " + scoreBoard.getScore());
        System.out.println("Lives: "+ player.getLives());
        for (int i = 0; i < gridHeight; i++) {
            for (int j = 0; j < gridWidth; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public void start() {    
        while (running) {
            clearGrid();

            char input = InputHandler.getInput();
            switch (input) {
                case 'a': 
                    player.moveLeft();
                    break;
                case 'd':
                    player.moveRight();
                    break;
                case ' ':
                    bullets.add(new Bullet(player.getX(), player.getY(), 1, 1));
                default: 
                    break;
            }

            for (Enemy enemy : enemies) {
                enemy.update();

                if(enemy.isActive()){
                    enemy.render(grid);
                }
                if (random.nextInt(5) == 0) { 
                    Bomb bomb = (Bomb) GameFactory.createObject("Bomb", enemy.getX(), enemy.getY(), 1, 1, gridWidth, gridHeight);
                    bombs.add(bomb);
                }
            }

            player.render(grid);

            for (Barrier barrier : barriers) {
                if (barrier.isActive()){
                    barrier.render(grid);
                }
            }

            for (Bullet bullet : bullets) {
                bullet.update();
                if (bullet.isActive()) {
                    bullet.render(grid);
                }
            }

            for (Bullet bullet : bullets) {
                for (Enemy enemy : enemies) {
                    collisionChain.handleCollision(bullet, enemy);
                }

                for (Barrier barrier : barriers) {
                    collisionChain.handleCollision(bullet, barrier);
                }
            }

            for (Bomb bomb : bombs) {
                for (Barrier barrier : barriers) {
                    collisionChain.handleCollision(bomb, barrier);
                }
                collisionChain.handleCollision(bomb, player);
                bomb.update();
                bomb.render(grid);
            }

            if (areAllEnemiesInactive()) {
                initializeEnemies();
            }

            if (checkGameOver()) {
                HighScoreManager highScoreManager = HighScoreManager.getInstance();
                highScoreManager.checkAndUpdateHighScore(scoreBoard.getScore());
                running = false;
                System.out.println("Game Over! Your score: " + scoreBoard.getScore() + " High Score: " + highScoreManager.getHighScore());
                break;
            }

            renderGrid();
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}