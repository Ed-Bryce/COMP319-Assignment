public abstract class CollisionHandler {
    protected CollisionHandler successor;
    protected ScoreBoard scoreBoard;
    protected SoundManager soundManager;

    /**
     * CollisionHandler constructor
     * @param scoreBoard active scoreboard instance
     * @param soundManager active soundmanager instance
     */
    public CollisionHandler(ScoreBoard scoreBoard, SoundManager soundManager){
        this.scoreBoard = scoreBoard;
        this.soundManager = soundManager;
    }

    /**
     * Handles the creation of the collision succession tree
     * @param successor CollisionHandler that will act as successor
     */
    public void setSuccessor(CollisionHandler successor) {
        this.successor = successor;
    }

    /**
     * Takes 2 gameOjects, checks if they collide, performs necessary logic on collision 
     * @param object1 first gameObject to check collision on
     * @param object2 second gameObject to check collision on
     */
    public abstract void handleCollision(GameObject object1, GameObject object2);

    /**
     * Provides the logic to check if 2 gameObjects collide given their coordinates and their size
     * @param obj1 first gameObject to check collision on
     * @param obj2 second gameObject to check collision on
     * @return boolean, true if a collision has occured, false otherwise
     */
    protected boolean checkCollision(GameObject obj1, GameObject obj2) {
        return obj1.getX() < obj2.getX() + obj2.getWidth() &&
               obj1.getX() + obj1.getWidth() > obj2.getX() &&
               obj1.getY() < obj2.getY() + obj2.getHeight() &&
               obj1.getY() + obj1.getHeight() > obj2.getY();
    }
}
