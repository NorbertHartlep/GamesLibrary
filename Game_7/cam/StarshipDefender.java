package Game_7.cam;

import Game_6.com.Board;
import utils.Game;

import javax.swing.*;
import java.awt.*;

public class StarshipDefender extends JFrame implements Game {

    public StarshipDefender(){
        initUI();
    }

    private void initUI(){

        add(new Board());

        setTitle("StarShip");
        setSize(Params.BOARD_WIDTH,Params.BOARD_HEIGHT);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void init() {

        EventQueue.invokeLater(() -> {

            var ex = new StarshipDefender();
            ex.setVisible(true);
        });
    }
}
