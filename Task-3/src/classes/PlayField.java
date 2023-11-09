package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayField  extends JPanel implements ActionListener {
    int counter;
    int xVelocity = 0;
    int yVelocity = 0;
    int x;
    int y;
    Player player = new Player();
    Image pacman;
    Image pacman_down;
    Image pacman_left;
    Image pacman_up;
    Image enemy;
    Image eatable;
    Image powerup;
    Image wall;
    Timer timer;
    KeyInput keyInput;


    // in the matrix 1 = wall, 0 = empty/eatable object, 3 = enemy, 7 = powerup
     int[][] level1 = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1},
            {1,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,0,1},
            {1,0,1,1,0,1,0,0,0,0,1,0,1,7,1,1,1,1,0,1},
            {1,0,1,1,0,1,0,1,1,3,1,0,1,0,1,1,1,1,0,1},
            {1,0,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1},
            {1,0,1,1,0,1,0,7,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1},
            {1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
            {1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,1,7,1},
            {1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,3,1},
            {1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {0,0,0,3,7,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {1,0,1,1,1,1,0,0,0,0,0,0,7,0,0,0,0,1,0,1},
            {1,0,0,0,7,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1}
    };
    public  static final String blue = "\033[1;34m";
    public  static final String reset = "\033[0m";

    private void turn( int xPosition, int yPosition){
        xVelocity = player.adjustXVelocity(keyInput.currentKey);
        yVelocity = player.adjustYVelocity(keyInput.currentKey);
    }

    private void clearPosition(int xPosition, int yPosition){
        try{
            if ((level1[yPosition][xPosition] == 0) && y % 36 == 0 && x % 36 == 0){
                ScorePanel.s++;
                level1[yPosition][xPosition] = 2;
            }
            if ((level1[yPosition][xPosition] == 7) && y % 36 == 0 && x % 36 == 0){

                level1[yPosition][xPosition] = 2;
            }
        }catch(Exception exception){

        }
    }

    PlayField(KeyInput keyInput){
        x = 1 * 36;
        y = 14 * 36;
        this.keyInput = keyInput;
        this.setBackground(Color.black);
        timer = new Timer(5, this);
        timer.start();

        // pac-man setup
//        pacman_opened = new ImageIcon("src/images/pacman-opened36px.png").getImage();
        pacman = new ImageIcon(getClass().getClassLoader().getResource("pacman36px.gif")).getImage();
        // pac-man facing down
        pacman_down = new ImageIcon(getClass().getClassLoader().getResource("pacman36px-DOWN.gif")).getImage();
        // pac-man facing left
        pacman_left = new ImageIcon(getClass().getClassLoader().getResource("pacman36px-LEFT.gif")).getImage();
        // pac-man facing up
        pacman_up = new ImageIcon(getClass().getClassLoader().getResource("pacman36px-UP.gif")).getImage();

        // enemy setup
//        enemy = new ImageIcon("src/images/phantom-blue36px.png").getImage();
        enemy = new ImageIcon(getClass().getClassLoader().getResource("phantom-blue36px.png")).getImage();
        //eatable setup
//        eatable = new ImageIcon("src/images/point9px.png").getImage();
        eatable = new ImageIcon(getClass().getClassLoader().getResource("point9px.png")).getImage();
        //powerup setup
//        powerup = new ImageIcon("src/images/cherry18px.png").getImage();
        powerup = new ImageIcon(getClass().getClassLoader().getResource("cherry18px.png")).getImage();
        //wall setup
        wall = new ImageIcon(getClass().getClassLoader().getResource("wall35px.jpg")).getImage();

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        // calls drawLevel and gives parameter g2D to draw the level
        drawLevel(g2D);
        //draws pacman at pos 36,36
        g2D.drawImage(pacman, x, y, this);

    }

    public void drawLevel(Graphics g2D) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (level1[i][j] == 1){
                    // draws a block of 35 pixels at position j*36,i*36
                    g2D.drawImage(wall, j* 36, i*36, this);
                } else if (level1[i][j] == 3) {
                    // draws the enemies
                    g2D.drawImage(enemy, j* 36, i*36, this);
                } else if (level1[i][j] == 7) {
                    // draws the powerups.
                    // I added 9 to the positions cus a powerup is only 18 pixels, for it to be in the middle of the cell(a cell being 36x36 pixels).
                    g2D.drawImage(powerup, (j* 36)+9, (i*36)+9, this);
                } else if (level1[i][j] == 0) {
                    // draws eatables.
                    // same story as for the powerups. in this case an eatable object is only 9 pixels in size, so I added 14.
                    g2D.drawImage(eatable, (j* 36)+14, (i*36)+14, this);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (keyInput.currentKey.equals("")){

        }else {
            int xPosition = x / 36;
            int yPosition = y / 36;


            try {
                switch (keyInput.currentKey) {
                    case "left":

                        if (level1[yPosition][xPosition - 1] != 1 && x % 36 == 0 && y % 36 == 0) {
                            turn(xPosition, yPosition);

                        }

                        break;
                    case "right":
                        if (level1[yPosition][xPosition + 1] != 1 && x % 36 == 0 && y % 36 == 0) {
                            turn(xPosition, yPosition);
                        }

                        break;
                    case "up":
                        if (level1[yPosition - 1][xPosition] != 1 && y % 36 == 0 && x % 36 == 0) {
                            turn(xPosition, yPosition);

                        }

                        clearPosition(xPosition, yPosition);
                        break;
                    case "down":
                        if (level1[yPosition + 1][xPosition] != 1 && y % 36 == 0 && x % 36 == 0) {
                            turn(xPosition, yPosition);
                        }

                        break;
                }
            }catch(Exception exception){
                clearPosition(xPosition, yPosition);
            }
            try {
                if (level1[yPosition][xPosition - 1] == 1 && x % 36 == 0 && y % 36 == 0 && xVelocity == -1) {
                    xVelocity = 0;
                    yVelocity = 0;
                } else if (level1[yPosition][xPosition + 1] == 1 && x % 36 == 0 && y % 36 == 0 && xVelocity == 1) {
                    xVelocity = 0;
                    yVelocity = 0;
                } else if (level1[yPosition - 1][xPosition] == 1 && x % 36 == 0 && y % 36 == 0 && yVelocity == -1) {
                    xVelocity = 0;
                    yVelocity = 0;
                } else if (level1[yPosition + 1][xPosition] == 1 && x % 36 == 0 && y % 36 == 0 && yVelocity == 1) {
                    xVelocity = 0;
                    yVelocity = 0;
                }
            }catch(Exception exception){
                clearPosition(xPosition, yPosition);
            }
            clearPosition(xPosition, yPosition);

            /*
            Adjusting players mouth direction
             */

            if (xVelocity == 1) {
                pacman = new ImageIcon(getClass().getClassLoader().getResource("pacman36px.gif")).getImage();
            }
            if (xVelocity == -1) {
                pacman = pacman_left;
            }
            if (yVelocity == 1) {
                pacman = pacman_down;
            }
            if (yVelocity == -1) {
                pacman = pacman_up;
            }

            /*
            Redirecting player if he goes over the margin
             */
            if (x >= this.getWidth()) {
                x = 0;
                level1[y/36][x/36] = 2;
            }
            if (x < 0) {
                x = this.getWidth();
            }
            if (y >= this.getHeight()) {
                y = 0;
                level1[y/36][x/36] = 2;
            }
            if (y < 0) {
                y = this.getHeight();
            }

            /*
            Updating x and y in regard to the new velocitys
             */
            x += xVelocity;
            y += yVelocity;


            repaint();
        }
    }
}
