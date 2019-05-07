import java.awt.Color;//imports java color from Abstract Window Toolkit (Minh Troung)
import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Minh Troung)
import java.awt.Rectangle;//imports java rectangle from Abstract Window Toolkit (Minh Troung)

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
