import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 *  This class was coded by Nathaniel Miller-Robbins. All It does it creates our window.
	 */
	private static final long serialVersionUID = 1L;
	
	public Window(int w, int h, String name, Game game) {
		JFrame window = new JFrame(name);
		
		window.setPreferredSize(new Dimension(w, h));
		window.setMaximumSize(new Dimension(w, h));
		window.setMinimumSize(new Dimension(w, h));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // makes the x button work
		window.setResizable(false);
		window.setLocationRelativeTo(null); // makes the game start in the middle of the screen
		window.add(game);
		window.setVisible(true);
		game.start(); // start the game on window create.

	}

}
