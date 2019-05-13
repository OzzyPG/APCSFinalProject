import java.awt.Color;//imports java color from Abstract Window Toolkit (Sameer Nasir)




//// this whole file is sameer 


import java.awt.Font;
import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Sameer Nasir)

public class Score {//creates a public class named Score (Sameer Nasir)
	private Handler handler;//creates a private Handler named handler (Sameer Nasir)
	
	Score(Handler handler) {
		this.handler = handler;
	}
	public static int score = 0;//the int score is set to 0 (Sameer Nasir)
	

	
	public void tick() { //uses the tick to calculate the score
	score++; //adds 1 to the score per tick (Sameer Nasir)
	
	
	if (score == 880) {
		handler.wave(15);
	}
	
	if (score == 3315) { 
		handler.wave(20);
	}
	}
	
	public void render(Graphics g) {//renders the graphics for the score (Sameer Nasir)
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.BOLD,22));
		g.drawString("Score " + score, 0, 20);//draws the score (Sameer Nasir)
		g.setColor(Color.black);//sets the score color (Sameer Nasir)
	}
	
	public static int getScore() {//gets the score (Sameer Nasir)
		return score;//returns the score (Sameer Nasir)
	}

}

