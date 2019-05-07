import java.awt.Graphics;//imports java graphics from Abstract Window Toolkit (Sameer Nasir)
import java.awt.Rectangle;//imports java rectangle from Abstract Window Toolkit (Sameer Nasir)

/// this is so that all the game objects will have access to the methods here. (Sameer Nasir)
public abstract class GameObject {
	
	
	// location (Sameer Nasir)
	protected int x;//both enemies and players x-coordinate (Sameer Nasir)
	protected int y;//both enemies and players y-coordinate (Sameer Nasir)
	
	
	//velocity (Sameer Nasir)
	protected int speedX;//both enemies and players horizontal speed (Sameer Nasir)
	protected int speedY;//both enemies and players vertical speed (Sameer Nasir)
	
	// differencates from the player (Sameer Nasir)
	protected boolean isEnemy;//boolean for identifying objects (Sameer Nasir)
	
	public GameObject(int x, int y, boolean isEnemy) {//any game objects x value, y value, and if they are an enemy or not (Sameer Nasir)
		this.x = x;//the x value is set to x (Sameer Nasir)
		this.y = y;//the y value is set to y (Sameer Nasir)
		this.isEnemy = isEnemy;//the isEnemy is set to new one (Sameer Nasir)
	}
	
	
	
	
	
	////// Getters and Setters (Sameer Nasir)
	
	public void sety(int y) {//sets the y value (Sameer Nasir)
		this.y = y;//sets the y value to the new one (Sameer Nasir)
	}
	public void setx(int x) {//sets the x value (Sameer Nasir)
		this.x = x;//sets the x value to the new one (Sameer Nasir)
	}
	public int getx() {//gets the x value (Sameer Nasir)
		return x;//returns the x value (Sameer Nasir)
	}
	public int getY() {//gets the y value (Sameer Nasir)
		return y;//returns the y value (Sameer Nasir)
	}
	public void setisEnemy(boolean isEnemy) {//sets IsEnemy (Sameer Nasir)
	this.isEnemy = isEnemy;//sets IsEnemy to new one (Sameer Nasir)
	}
	public boolean getIsEnemy() {//gets IsEnemy (Sameer Nasir)
		return isEnemy;//returns IsEnemy (Sameer Nasir)
	}
	public void setSpeedX(int x) {//sets the horizontal speed (Sameer Nasir)
		this.speedX = x;//sets the speedX to x (Sameer Nasir)
	
	}
	public void setSpeedY(int y) {//sets the vertical speed (Sameer Nasir)
		this.speedY = y;//sets the speedY to y (Sameer Nasir)
	 
	}
	public int getspeedY() {//gets the vertical speed (Sameer Nasir)
		return speedY;//returns the vertical speed (Sameer Nasir)
		
	}
	public int getspeedX() {//gets the horizontal speed (Sameer Nasir)
		return speedX;//returns the horizontal speed (Sameer Nasir)
	}

	// Tick and render for game loops (Sameer Nasir)
	public abstract void tick();//gives the game object access (Sameer Nasir)
	public abstract void render(Graphics g);//gives the game object access (Sameer Nasir)
	public abstract Rectangle collide();//gives the game object access (Sameer Nasir)

}
