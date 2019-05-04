import java.awt.Color;
import java.awt.Graphics;

public class Score {
	private Handler handler;
	
	public static int score = 0;
	public void tick() {
	score++;
		
	}
	public void render(Graphics g) {
		g.drawString("Score " + score, 0, 10);
		g.setColor(Color.black);
	}
	
	public static int getScore() {
		return score;
	}

}

