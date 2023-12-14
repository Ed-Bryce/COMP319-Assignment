public abstract class CollisionHandler {
    protected CollisionHandler successor;
    protected ScoreBoard scoreBoard;

    public CollisionHandler(ScoreBoard scoreBoard){
        this.scoreBoard = scoreBoard;
    }

    public void setSuccessor(CollisionHandler successor) {
        this.successor = successor;
    }

    public abstract void handleCollision(GameObject object1, GameObject object2);

    protected boolean checkCollision(GameObject obj1, GameObject obj2) {
        return obj1.getX() < obj2.getX() + obj2.getWidth() &&
               obj1.getX() + obj1.getWidth() > obj2.getX() &&
               obj1.getY() < obj2.getY() + obj2.getHeight() &&
               obj1.getY() + obj1.getHeight() > obj2.getY();
    }
}
