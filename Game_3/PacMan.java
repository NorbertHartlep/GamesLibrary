package Game_3;

import utils.Game;

import javax.swing.*;
import java.awt.*;

public class PacMan extends JFrame implements Game {

    public PacMan(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(380,420);
        setLocationRelativeTo(null);
    }
    @Override
    public void init() {
        EventQueue.invokeLater(() -> {
            PacMan ex = new PacMan();
            ex.setVisible(true);
        });
    }
}
