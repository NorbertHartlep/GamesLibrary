package Game_7.sprite;

import Game_7.cam.Params;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Player extends Sprite{

    private int width;

    public Player() {

        var playerImg = "src/Game_7/images/player.png";
        var img = new ImageIcon(playerImg);

        width = img.getImage().getWidth(null);
        setImage(img.getImage());

        int START_X = 270;
        setX(START_X);

        int START_Y = 280;
        setY(START_Y);
    }

    public void act(){
         x+=dx;

         if(x<=2){
             x=2;
         }

         if(x>= Params.BOARD_WIDTH - 2*width){

             x = Params.BOARD_WIDTH - 2*width;
         }
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = -2;
        }

        if(key == KeyEvent.VK_RIGHT){
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }

        if(key == KeyEvent.VK_RIGHT){
            dx = 0;
        }
    }
}
