import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

	public Player(int x, int y, boolean isEnemy) {
		super(x, y, isEnemy);
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		
		
		x = Game.wall(x, 800 - 32, 0);
		y = Game.wall(y, 600 - 50, 0);
		
		
	}
	
	public Rectangle collide() {
		return new Rectangle(x, y, 10, 10);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
		
	}

}
