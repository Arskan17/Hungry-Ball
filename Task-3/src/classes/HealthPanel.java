package classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HealthPanel extends JPanel {
    HealthPanel(){
        this.setBackground(Color.black);
        this.setLayout(new FlowLayout());

//        ImageIcon hearth = new ImageIcon("src/images/hearth36px.png");
        ImageIcon hearth = new ImageIcon(getClass().getClassLoader().getResource("hearth36px.png"));
        hearth.setImage(hearth.getImage());

        JLabel[] hearths = new JLabel[3];

        for(int i = 0; i<3; i++){
            hearths[i] = new JLabel(hearth);
        }


        this.add(hearths[0]);
        this.add(hearths[1]);
        this.add(hearths[2]);
    }
}
