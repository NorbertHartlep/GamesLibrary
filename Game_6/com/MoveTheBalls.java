package Game_6.com;

import utils.Game;

import javax.swing.*;
import java.awt.*;

public class MoveTheBalls extends JFrame implements Game{

    private final int OFFSET = 30;

    public MoveTheBalls(){
        initUI();
    }

    private void initUI(){
        Board board = new Board();
        add(board);

        setTitle("SBall");

        setSize(board.getBoardWidth() + OFFSET, board.getBoardHeight() + 2 * OFFSET);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void init() {
        EventQueue.invokeLater(() -> {
            MoveTheBalls game = new MoveTheBalls();
            game.setVisible(true);
        });
    }
}
