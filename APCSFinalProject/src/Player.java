import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, boolean isEnemy) {
		super(x, y, isEnemy);
		
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 25, 25);
		
	}

}
