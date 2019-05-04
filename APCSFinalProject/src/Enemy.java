import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{

	public Enemy(int x, int y, boolean isEnemy) {
		super(x, y, isEnemy);
		speedX = 5;	
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		if (x >= 800) {
			x = 0;
			y = (int) Math.floor(Math.random() * (599 - 1));
		}
		
	}
	
	
	public Rectangle collide() {
		return new Rectangle(x, y, 25, 25);
	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 25, 25);
		
	}
	

}
