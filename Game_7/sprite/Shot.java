package Game_7.sprite;

import javax.swing.*;

public class Shot extends Sprite{

    public Shot() {

    }

    public Shot(int x, int y){
        initShot(x,y);
    }

    private void initShot(int x, int y){

        var shotImg = "src/Game_7/images/shot.png";
        var img = new ImageIcon(shotImg);
        setImage(img.getImage());

        int X_SPACE = 6;
        setX(x + X_SPACE);

        int Y_SPACE = 1;
        setY(y - Y_SPACE);
    }
}
