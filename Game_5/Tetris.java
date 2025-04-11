package Game_5;

import utils.Game;

import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame implements Game  {
    private JLabel statusbar;

    public Tetris(){
        initUI();
    }

    private void initUI(){
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar(){
        return statusbar;
    }

    @Override
    public void init() {
        EventQueue.invokeLater(() -> {
            var game = new Tetris();
            game.setVisible(true);
        });
    }
}
