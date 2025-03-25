package Game_3;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Dimension d;
    private final Font smallFont = new Font("Helvetica",Font.BOLD,14);

    private Image ii;
    private final Color dotColor = new Color(192,192,0);
    private Color mazeColor;

    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS*BLOCK_SIZE;
    private final int PAC_ANIM_DELAY = 2;
    private final int PACMAN_ANIM_COUNT = 4;
    private final int MAX_GHOSTS = 1;
    private final int PACMAN_SPEED = 6;

    private int pacAnimCount = PAC_ANIM_DELAY;
    private int pacAnimDir = 1;
    private int pacmanAnimPos = 0;
    private int N_GHOSTS = 6;
    private int pacsLeft, score;
    private int[] dx,dy;
    private int[] ghost_x,ghost_y,ghost_dx,ghost_dy, ghostSpeed;

    private int pacman_x,pacman_y,pacman_dx,pacman_dy;
    private int req_dx,req_dy,view_dx,vidw_dy;

    private final short levelData[] = {"to fill"};

    private final int validSpeeds[] = {1,2,3,4,6,8};
    private final int maxSpeed = 6;

    private int currentSpeed = 3;
    private short[] screenData;
    private Timer timer;
}
