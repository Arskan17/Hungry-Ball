package classes;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    BottomPanel() {
        this.setBackground(Color.black);
        HealthPanel healthPanel = new HealthPanel();
        PowerupPanel powerupPanel = new PowerupPanel();

        this.setLayout(new BorderLayout());
        this.add(healthPanel, BorderLayout.WEST);
        this.add(powerupPanel, BorderLayout.EAST);

    }
}
