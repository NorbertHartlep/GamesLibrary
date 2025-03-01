package Game_1;

import javax.swing.JFrame;


public class BrickBreaker {
    public void init() {
        JFrame obj = new JFrame();
        GamePlay gamePlay = new GamePlay();
        obj.setBounds(10, 10, 700, 600);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setTitle("Brick Brealer Game");
        obj.setResizable(false);
        obj.add(gamePlay);
    }
}
