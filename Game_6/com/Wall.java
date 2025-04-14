package Game_6.com;

import javax.swing.*;
import java.awt.*;

public class Wall extends Actor{

    private Image image;

    public Wall(int x, int y){

        super(x,y);
        initWall();
    }

    private void initWall(){
        ImageIcon icon = new ImageIcon("src/Game_6/resources/wall.png");
        image = icon.getImage();
        setImage(image);
    }
}
