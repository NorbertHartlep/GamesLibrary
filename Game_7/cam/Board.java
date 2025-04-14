package Game_7.cam;

import Game_7.sprite.Alien;
import Game_7.sprite.Player;
import Game_7.sprite.Shot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import javax.swing.Timer;
public class Board extends JPanel {

    private Dimension d;
    private List<Alien> aliens;
    private Player player;
    private Shot shot;

    private int direction = -1;
    private int deaths = 0;

    private boolean inGame = true;
    private String explImg = "src/Game_7/images/explosion.png";
    private String message = "Game Over!";

    private Timer timer;

    public Board(){
        initBoard();
        gameInit();
    }

    private void initBoard(){

        setFocusable(true);
        d = new Dimension(Params.BOARD_WIDTH, Params.BOARD_HEIGHT);
        setBackground(Color.black);

        gameInit();
    }

    private void gameInit(){

        aliens = new ArrayList<Alien>();

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 6; j++) {
                var alien = new Alien(Params.ALIEN_INIT_X+18 * j, Params.ALIEN_INIT_Y+18*i);
                aliens.add(alien);
            }
        }
        player = new Player();
        shot = new Shot();
    }

    private void drawAliens(Graphics g){
        for(Alien alien:aliens){
            if(alien.isVisible()){
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
            if(alien.isDying()){
                alien.die();
            }
        }
    }

    private void drawPlayer(Graphics g) {

        if (player.isVisible()) {

            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
        }

        if (player.isDying()) {

            player.die();
            inGame = false;
        }
    }

    private void drawShot(Graphics g) {

        if (shot.isVisible()) {

            g.drawImage(shot.getImage(), shot.getX(), shot.getY(), this);
        }
    }

    private void drawBombing(Graphics g) {

        for (Alien a : aliens) {

            Alien.Bomb b = a.getBomb();

            if (!b.isDestroyed()) {

                g.drawImage(b.getImage(), b.getX(), b.getY(), this);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }


    private void doDrawing(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);

        if(inGame) {

            g.drawLine(0, Params.GROUND, Params.BOARD_WIDTH, Params.GROUND);

            drawAliens(g);
            drawPlayer(g);
            drawShot(g);
            drawBombing(g);

        } else {

            if (timer.isRunning()) {
                timer.stop();
            }

            gameOver(g);

        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void gameOver(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, Params.BOARD_WIDTH, Params.BOARD_HEIGHT);

        g.setColor(new Color(0, 32, 48));
        g.fillRect(50, Params.BOARD_WIDTH/ 2 - 30, Params.BOARD_WIDTH - 100, 50);
        g.setColor(Color.white);
        g.drawRect(50, Params.BOARD_WIDTH/ 2 - 30, Params.BOARD_WIDTH - 100, 50);

        var small = new Font("Helvetica", Font.BOLD, 14);
        var fontMetrics = this.getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (Params.BOARD_WIDTH - fontMetrics.stringWidth(message)) / 2,
                Params.BOARD_WIDTH / 2);
    }


    private void update() {

        if(deaths == Params.NUMBER_OF_ALIENS_TO_DISPLAY) {

            inGame = false;
            timer.stop();
            message = "You won!";
        }



        player.act();

        if (shot.isVisible()) {

            int shotX = shot.getX();
            int shotY = shot.getY();

            for (Alien alien : aliens) {

                int alienX = alien.getX();
                int alienY = alien.getY();

                if(alien.isVisible() && shot.isVisible()) {
                    if (shotX >= (alienX)
                            && shotX <= (alienX + Params.ALIEN_WIDTH)
                            && shotY >= (alienY)
                            && shotY <= (alienY + Params.ALIEN_HEIGHT)) {

                        var img = new ImageIcon(explImg);
                        alien.setImage(img.getImage());
                        alien.setDying(true);
                        deaths++;
                        shot.die();
                    }
                }
            }

            int y = shot.getY();
            y-=4;

            if (y<0) {
                shot.die();
            } else {
                shot.setY(y);
            }
        }

        for (Alien alien : aliens) {

            int x = alien.getX();

            if (x >= Params.BOARD_WIDTH - Params.BORDER_RIGHT && direction != -1) {

                direction = -1;

                Iterator<Alien> i1 = aliens.iterator();

                while (i1.hasNext()) {

                    Alien a2 = i1.next();
                    a2.setY(a2.getY() + Params.GO_DOWN);
                }
            }

            if (x <= Params.BORDER_LEFT && direction != 1) {

                direction = 1;

                Iterator<Alien> i2 = aliens.iterator();

                while (i2.hasNext()) {

                    Alien a = i2.next();
                    a.setY(a.getY() + Params.GO_DOWN);
                }
            }
        }

        Iterator<Alien> it = aliens.iterator();

        while (it.hasNext()) {

            Alien alien = it.next();

            if (alien.isVisible()) {

                int y = alien.getY();

                if (y > Params.GROUND - Params.ALIEN_HEIGHT) {

                    inGame = false;
                    message = "Invasion!";
                }

                alien.act(direction);
            }
        }

        var generator = new Random();

        for(Alien alien : aliens) {

            int shot = generator.nextInt(15);
            Alien.Bomb bomb = alien.getBomb();

            if (shot == Params.CHANCE && alien.isVisible() && bomb.isDestroyed()) {

                bomb.setDestroyed(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());

            }

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int playerX = player.getX();
            int playerY = player.getY();

            if (player.isVisible() && !bomb.isDestroyed()) {

                if(bombX >=(playerX)
                        && bombX <= (playerX + Params.PLAYER_WIDTH)
                        && bombY >= (playerY)
                        && bombY <= (playerY + Params.PLAYER_HEIGHT)) {

                    var img = new ImageIcon(explImg);
                    player.setImage(img.getImage());
                    player.setDying(true);
                    bomb.setDestroyed(true);

                }
            }

            if (!bomb.isDestroyed()) {

                bomb.setY(bomb.getY() + 1);

                if (bomb.getY() >= Params.GROUND - Params.BOMB_HEIGHT) {

                    bomb.setDestroyed(true);
                }
            }


        }
    }

    private void doGameCycle() {

        update();
        repaint();
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }

    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            player.keyPressed(e);

            int x = player.getX();
            int y = player.getY();

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if(inGame) {

                    if (!shot.isVisible()) {

                        shot = new Shot(x, y);
                    }
                }
            }
        }
    }

}
