package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePitch extends JFrame {

    GamePitch() {
        // setting the frame up
        this.setTitle("Hungry-Ball"); // app title
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(736, 840);// window dimensions

//        ImageIcon image = new ImageIcon("src/images/logo.jpg"); // app logo
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("logo.jpg"));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.black); // window background color
        this.setLayout(new BorderLayout()); // layout of the frame

        // adding components to the frame
        KeyInput keyInput = new KeyInput();
        WallNorth north_wall = new WallNorth();
        WallSouth south_wall = new WallSouth();
        ScorePanel scorePanel = new ScorePanel();
        BottomPanel bottomPanel = new BottomPanel();
        PlayField playField = new PlayField(keyInput);

        // add the score on top of the north wall
        north_wall.setLayout(new BorderLayout());
        north_wall.add(scorePanel, BorderLayout.NORTH);

        // add the health and powerup panels beneath the south wall
        south_wall.setLayout(new BorderLayout());
        south_wall.add(bottomPanel, BorderLayout.SOUTH);

        this.addKeyListener(keyInput);
        this.add(north_wall, BorderLayout.NORTH); // set north wall
        this.add(south_wall, BorderLayout.SOUTH); // set south wall
        this.add(playField, BorderLayout.CENTER); // set play field

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
