import java.awt.Color;//imports java color from Abstract Window Toolkit (Sameer Nasir)
import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Sameer Nasir)

public class Score {//creates a public class named Score (Sameer Nasir)
	private Handler handler;//creates a private Handler named handler (Sameer Nasir)
	public static int score = 0;//the int score is set to 0 (Sameer Nasir)
	public void tick() {//uses the tick to calculate the score
	score++;//adds 1 to the score per tick (Sameer Nasir)
	}
	
	public void render(Graphics g) {//renders the graphics for the score (Sameer Nasir)
		g.drawString("Score " + score, 0, 10);//draws the score (Sameer Nasir)
		g.setColor(Color.black);//sets the score color (Sameer Nasir)
	}
	
	public static int getScore() {//gets the score (Sameer Nasir)
		return score;//returns the score (Sameer Nasir)
	}

}

