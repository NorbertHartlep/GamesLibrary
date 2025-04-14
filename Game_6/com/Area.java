package Game_6.com;

import javax.swing.*;
import java.awt.*;

public class Area extends Actor{
    public Area(int x, int y){

        super(x,y);
        initArea();
    }

    private void initArea(){

        ImageIcon icon = new ImageIcon("src/Game_6/resources/area.png");
        Image image = icon.getImage();
        setImage(image);
    }
}
