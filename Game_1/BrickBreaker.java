package Game_1;

import utils.Game;

import javax.swing.*;


public class BrickBreaker implements Game {
    public void init() {
        JFrame obj = new JFrame();
        BrickBreakerGamePlay gamePlay = new BrickBreakerGamePlay();
        obj.setBounds(10, 10, 700, 600);
        obj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        obj.setVisible(true);
        obj.setTitle("Brick Breaker Game");
        obj.setResizable(false);
        obj.add(gamePlay);
    }
}
