import java.awt.Graphics;
import java.awt.Rectangle;

/// this is so that all the game objects will have access to the methods here.
public abstract class GameObject {
	
	
	// location
	protected int x;
	protected int y;
	
	
	//velocity
	
	protected int speedX;
	protected int speedY;
	
	// differencates from the player
	protected boolean isEnemy;
	
	public GameObject(int x, int y, boolean isEnemy) {
		this.x = x;
		this.y = y;
		this.isEnemy = isEnemy;
	}
	
	
	
	
	
	////// Getters and Setters
	
	public void sety(int y) {
		this.y = y;
		
	}
	public void setx(int x) {
		this.x = x;
		
	}
	public int getx() {
		return x;
	
	}
	public int getY() {
		return y;
	
	}
	public void setisEnemy(boolean isEnemy) {
	this.isEnemy = isEnemy;
	}
	public boolean getIsEnemy() {
		return isEnemy;
	}
	public void setSpeedX(int x) {
		this.speedX = x;
	
	}
	public void setSpeedY(int y) {
		this.speedY = y;
	
	}
	public int getspeedY() {
		return speedY;
		
		
	}
	public int getspeedX() {
		return speedX;
	}
	
	
	
	
	


	// Tick and render for game loops
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public abstract Rectangle collide();

}
