package classes;

import javax.swing.*;
import java.awt.*;

public class PowerupPanel extends JPanel {
    PowerupPanel(){
        this.setBackground(Color.black);

        JLabel powerup = new JLabel();

//        ImageIcon fruit = new ImageIcon("src/images/cherry36px.png");
        ImageIcon fruit = new ImageIcon(getClass().getClassLoader().getResource("cherry36px.png"));

        fruit.setImage(fruit.getImage());

        powerup.setIcon(fruit);

        powerup.setForeground(Color.yellow);

        this.add(powerup);
    }
}
