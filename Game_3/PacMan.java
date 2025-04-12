package Game_3;

import utils.Game;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PacMan extends JFrame implements Game {
	
	public PacMan() {
		
		initUI();
	
	}
	
	private void initUI() {
		add(new Board());
		
		setTitle("Pacman");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(380,420);
		setLocationRelativeTo(null);
		
	}

	@Override
	public void init() {
		EventQueue.invokeLater(() -> {

			PacMan ex = new PacMan();
			ex.setVisible(true);

			String filepath = "pacmanMusic.wav";
			Board musicObject = new Board();
			musicObject.playMusic(filepath);


		});
	}
}
