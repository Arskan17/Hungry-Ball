package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ScorePanel extends JPanel {
    public static int s = 0;
    ScorePanel(){
        this.setBackground(Color.black);
        JLabel score = new JLabel();

        score.setText("Score: " + s);
        score.setForeground(Color.green);
        this.add(score);

    }
}
