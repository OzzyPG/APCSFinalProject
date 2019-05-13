import java.awt.Color;//imports java color from Abstract Window Toolkit (Minh Troung)
import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Minh Troung)
import java.awt.Rectangle;//imports java rectangle from Abstract Window Toolkit (Minh Troung)

public class Player extends GameObject {//public class Player extends the GameObject (Minh Troung)
	
	
	
	
//////This whole file is minh, with help on the render and collide methods and comments by sameer


	public Player(int x, int y, boolean isEnemy, int i, Color color, boolean isAlive) {//the player class that has the x and y coordinates and whether they are an enemy (Minh Troung)
		super(x, y, isEnemy, i, color);//the updated x and y coordinates and if they are an enemy (Minh Troung)
	}

	@Override
	public void tick() {//tick class that uses time (Minh Troung)
		x += speedX;//horizontal speed of the player (Minh Troung)
		y += speedY;//vetical speed of the player (Minh Troung)
		
		
		x = Game.wall(x, 800 - 32, 0);//x coordinate of the game itself (Minh Troung)
		y = Game.wall(y, 600 - 50, 0);//y coordinate of the game itself (Minh Troung)
		
		
	}
	
	public Rectangle collide() {//if the player collides (Minh Troung)
		return new Rectangle(x, y, 10, 10);//returns a new rectangle for the play (Minh Troung)
	}

	public void render(Graphics g) {//renders the player  (Minh Troung)
		g.setColor(color);//the play is set to the color blue (Minh Troung)
		g.fillRect(x, y, 10, 10);//the rectangle is filled with the color blue (Minh Troung)
		
	}

}
