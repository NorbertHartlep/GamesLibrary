package Game_2;

import utils.Game;

import javax.swing.*;
import java.awt.*;
public class Snake implements Game {
    public void init(){

        JFrame obj = new JFrame();
        SnakeGamePlay snakeGamePlay = new SnakeGamePlay();
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setTitle("Snake Game");
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        obj.add(snakeGamePlay);
    }
}
