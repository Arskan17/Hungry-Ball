package classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    public String currentKey = "";
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
            currentKey = "right";
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
            currentKey = "left";
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key pressed");
            currentKey = "down";
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key pressed");
            currentKey = "up";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
