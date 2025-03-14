package Game_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SnakeGamePlay extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon headRight;
    private ImageIcon headLeft;
    private ImageIcon headUp;
    private ImageIcon headDown;

    private int lengthOfSnake = 3;

    private Timer timer;
    private int delay = 100;

    private ImageIcon tail;
    private int moves = 0;
    private int score = 0;

    private int [] fruitXpos = {
            25,50,75,100,
            125,150,175,200,
            225,250,275,300,
            325,350,375,400,
            425,450,475,500,
            525,550,575,600,
            625,650,675,700,
            725,750,775,800,
            825,850
    };

    private int [] fruitYpos = {
            75,100,
            125,150,175,200,
            225,250,275,300,
            325,350,375,400,
            425,450,475,500,
            525,550,575,600,
            625
    };

    private ImageIcon fruitImg;

    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);


    private ImageIcon titleImage;

    public SnakeGamePlay(){

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(delay,this);
        timer.start();
    }

    public void paint(Graphics g){

        if(moves == 0){
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;

        }
        titleImage = new ImageIcon("src/Game_2/title.png");
        titleImage.paintIcon(this,g,25,5);

        g.setColor(Color.DARK_GRAY);
        g.drawRect(24,74,851,577);

        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,575);

        g.setColor(Color.white);
        g.setFont(new Font("areal", Font.PLAIN,14));
        g.drawString("Scores: "+score,780,30);

        g.setColor(Color.white);
        g.setFont(new Font("areal", Font.PLAIN,14));
        g.drawString("Length: "+lengthOfSnake,780,50);

        headRight = new ImageIcon("src/Game_2/headRight.png");
        headRight.paintIcon(this,g,snakeXlength[0],snakeYlength[0]);

        for (int i = 0; i < lengthOfSnake; i++) {
            if(i==0 && right){
                headRight = new ImageIcon("src/Game_2/headRight.png");
                headRight.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i==0 && left){
                headLeft = new ImageIcon("src/Game_2/headLeft.png");
                headLeft.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i==0 && up){
                headUp = new ImageIcon("src/Game_2/headUp.png");
                headUp.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i==0 && down){
                headDown = new ImageIcon("src/Game_2/headDown.png");
                headDown.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }
            if(i !=0){
                tail = new ImageIcon("src/Game_2/tail.png");
                tail.paintIcon(this,g,snakeXlength[i],snakeYlength[i]);
            }

            fruitImg = new ImageIcon("src/Game_2/fruit.png");

            if(fruitXpos[xpos] == snakeXlength[0] && fruitYpos[ypos] == snakeYlength[0]){
                score+=5;
                lengthOfSnake++;
                xpos = random.nextInt(34);
                ypos = random.nextInt(23);
            }
            fruitImg.paintIcon(this,g,fruitXpos[xpos],fruitYpos[ypos]);
        }

        for (int i = 1; i < lengthOfSnake; i++) {
            if(snakeXlength[i] == snakeXlength[0] && snakeYlength[i] == snakeYlength[0]){
                right = false;
                left = false;
                up = false;
                down = false;

                g.setColor(Color.RED);
                g.setFont(new Font("areal", Font.BOLD, 40));
                g.drawString("Game over! Score:" + score,250,300);

                g.setColor(Color.WHITE);
                g.setFont(new Font("areal", Font.BOLD, 20));
                g.drawString("Press Enter to restart" ,350,340);
            }
        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.restart();
        if(right)
        {
            for(int n = lengthOfSnake-1; n>=0;n--)
            {
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = lengthOfSnake; n>=0; n--)
            {
                if (n==0)
                {
                    snakeXlength[n] = snakeXlength[n]+25;
                }
                else
                {
                    snakeXlength[n] = snakeXlength[n-1];
                }
                if(snakeXlength[n] >850)
                {
                    snakeXlength[n] = 25;
                }

            }
            repaint();
        }

        if(left)
        {
            for(int n = lengthOfSnake-1; n>=0;n--)
            {
                snakeYlength[n+1] = snakeYlength[n];
            }
            for(int n = lengthOfSnake; n>=0; n--)
            {
                if (n==0)
                {
                    snakeXlength[n] = snakeXlength[n]-25;
                }
                else
                {
                    snakeXlength[n] = snakeXlength[n-1];
                }
                if(snakeXlength[n] < 25)
                {
                    snakeXlength[n] = 850;
                }

            }
            repaint();

        }
        if(up)
        {
            for(int n = lengthOfSnake-1; n>=0;n--)
            {
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = lengthOfSnake; n>=0; n--)
            {
                if (n==0)
                {
                    snakeYlength[n] = snakeYlength[n]-25;
                }
                else
                {
                    snakeYlength[n] = snakeYlength[n-1];
                }
                if(snakeYlength[n] < 75)
                {
                    snakeYlength[n] = 625;
                }

            }
            repaint();

        }
        if(down)
        {
            for(int n = lengthOfSnake-1; n>=0;n--)
            {
                snakeXlength[n+1] = snakeXlength[n];
            }
            for(int n = lengthOfSnake; n>=0; n--)
            {
                if (n==0)
                {
                    snakeYlength[n] = snakeYlength[n]+25;
                }
                else
                {
                    snakeYlength[n] = snakeYlength[n-1];
                }
                if(snakeYlength[n] > 625)
                {
                    snakeYlength[n] = 75;
                }

            }

            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(!left){
                right = true;
            } else {
                right = false;
                left = true;
            }
            up = false;
            down = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right){
                left = true;
            } else {
                left = false;
                right = true;
            }
            up = false;
            down = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down){
                up = true;
            } else {
                up = false;
                down = true;
            }
            left = false;
            right = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up){
                down = true;
            } else {
                down = false;
                up = true;
            }
            left = false;
            right = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            moves = 0;
            score = 0;
            lengthOfSnake = 3;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
