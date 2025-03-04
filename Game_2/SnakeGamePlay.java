package Game_2;

import javax.swing.*;
import java.awt.*;

public class SnakeGamePlay extends JPanel{

    private ImageIcon titleImage;

    public void paint(Graphics g){

        titleImage = new ImageIcon("src/Game_2/title.png");
        titleImage.paintIcon(this,g,25,5);

        g.setColor(Color.DARK_GRAY);
        g.drawRect(24,74,851,577);

        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,575);

        g.dispose();
    }
}
