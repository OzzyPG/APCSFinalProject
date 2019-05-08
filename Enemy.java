import java.awt.Color;//imports java colors from Abstract Window Toolkit (Sameer Nasir)
import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Sameer Nasir)
import java.awt.Rectangle;//imports java rectangle from Abstract Window Toolkit (Sameer Nasir)

public class Enemy extends GameObject{//creates a public class that makes the subclass extended into the inheritance(Sameer Nasir)

	public Enemy(int x, int y, boolean isEnemy) {//public enemy uses int x, int y, and boolen isEnemy to find corrdinates (Sameer Nasir)
		super(x, y, isEnemy);//super uses the x, y, and isEnemy (Sameer Nasir)
		speedX = 5;//how fast the enemy travels per tick on the x-axis (Sameer Nasir)
	}

	@Override
	public void tick() {//creates a new class named tick that does not return anything (Sameer Nasir)
		x += speedX;//x is speedX + x (Sameer Nasir)
		y += speedY;//y is speedY + y (Sameer Nasir)
		if (x >= 800) {//if x is greater than or equal to 800 than it will run (Sameer Nasir)
			x = 0;//x is set to 0 (Sameer Nasir)
			y = (int) Math.floor(Math.random() * (599 - 1));//the y value is random from 1- 600 (Sameer Nasir)
		}
		
	}
	
	
	public Rectangle collide() {//if the rectangle collides (Sameer Nasir)
		return new Rectangle(x, y, 25, 25);//it will return a new rectangle (Sameer Nasir)
	}


	@Override
	public void render(Graphics g) {//public class that renders the graphics (Sameer Nasir)
		g.setColor(Color.red);//the graphic g is set to the color red (Sameer Nasir)
		g.fillRect(x, y, 25, 25);//g is filled with the color (Sameer Nasir)
		
	}
	

}
