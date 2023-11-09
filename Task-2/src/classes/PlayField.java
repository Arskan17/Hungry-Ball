package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayField  extends JPanel implements ActionListener {
    int counter;
    int xVelocity = 1;
    int yVelocity = 0;
    int x = 230;
    int y;
    Image pacman_opened;
    Image pacman_closed;
    Image enemy;
    Image eatable;
    Image powerup;
    Timer timer;
    boolean mouthclosed = false;
    int playfieldWidth;

    PlayField(){

        this.setBackground(Color.black);
        timer = new Timer(5, this);
        timer.start();

        // pac-man setup
//        pacman_opened = new ImageIcon("src/images/pacman-opened36px.png").getImage();
        pacman_opened = new ImageIcon(getClass().getClassLoader().getResource("pacman-opened36px.png")).getImage();
//        pacman_closed = new ImageIcon("src/images/pacman-closed36px.png").getImage();
        pacman_closed = new ImageIcon(getClass().getClassLoader().getResource("pacman-closed36px.png")).getImage();

        // enemy setup
//        enemy = new ImageIcon("src/images/phantom-blue36px.png").getImage();
        enemy = new ImageIcon(getClass().getClassLoader().getResource("phantom-blue36px.png")).getImage();
        //eatable setup
//        eatable = new ImageIcon("src/images/point9px.png").getImage();
        eatable = new ImageIcon(getClass().getClassLoader().getResource("point9px.png")).getImage();
        //powerup setup
//        powerup = new ImageIcon("src/images/cherry18px.png").getImage();
        powerup = new ImageIcon(getClass().getClassLoader().getResource("cherry18px.png")).getImage();
        this.setLayout(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(eatable, this.getWidth()/2, this.getHeight()/5, this);
        g2D.drawImage(enemy, this.getWidth()/3, this.getHeight()/6, this);
        g2D.drawImage(powerup, this.getWidth()-120, this.getHeight()-80, this);

        playfieldWidth = this.getWidth();

        y = this.getHeight()/2;

        if(mouthclosed) {
            g2D.drawImage(pacman_closed, x, y, this);
        } else {
            g2D.drawImage(pacman_opened, x ,y, this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(x >= playfieldWidth){
            x = 0;
        }
        counter++;
        if(counter % 15 == 0) {
            mouthclosed = !mouthclosed;
        }

        x = x + xVelocity;
        repaint();
    }
}
