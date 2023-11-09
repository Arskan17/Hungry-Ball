package classes;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    ScorePanel(){
        this.setBackground(Color.black);
        JLabel score = new JLabel();

        score.setText("Score:");
        score.setForeground(Color.green);

        this.add(score);

    }
}
