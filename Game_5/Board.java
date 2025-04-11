package Game_5;

import javax.swing.*;

public class Board extends JPanel {
    private final int BOARD_WIDTH = 20;
    private final int BOARD_HEIGHT = 22;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusbar;
    private Shape.Tet[] board;

    public Board(Tetris parent){
        initBoard(parent);
    }

    private void initBoard(Tetris parent){
        setFocusable(true);
        statusbar = parent.getStatusBar();
    }

    private int squareWidth(){
        return (int) getSize().getWidth()/BOARD_WIDTH;
    }

    private int squareHeight(){
        return (int) getSize().getHeight()/BOARD_HEIGHT;
    }

    private Shape.Tet shapeAt(int x, int y) {
        return board[(y*BOARD_WIDTH) + x];
    }
}
