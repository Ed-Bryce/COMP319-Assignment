import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{
    private static boolean leftPressed;
    private static boolean rightPressed;
    private static boolean spacePressed;

    /**
     * Returns input from player
     * @return char, a, d or space, returns N of no key pressed
     */
    public static char getInput() {
        if (leftPressed) {
            return 'a';
        } 
        else if (rightPressed) {
            return 'd';
        }
        else if (spacePressed) {
            return ' ';
        }
        // Uncomment code below for random input for testing render to function.
        /**int max = 3;
        int min = 1;
        int random = (int) (Math.random()*(max-min+1)+min);
        switch (random){
            case 1:
                return 'a';
            case 2:
                return 'd';
            case 3:
                return ' ';
        }**/
        return 'N';

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
    }
}