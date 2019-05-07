import java.awt.Graphics;
import java.util.ArrayList;

// So this class will do the rendering updates, object creation, etc.
//its kinda slow but it is okay for what we are doing for this project
public class Handler {
	
	private Game game;
	
	
	
	
	
	
	//updates and renders every game object, every tick.
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	public boolean state = true;
	public int finalScore;
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);

			temp.tick();
		}
	}
	
	public void collision() {
		if (state == false) {
			return;
		}
		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			if (temp.getIsEnemy() == false) {
				GameObject p = temp;
				for (int k = 0; k < objects.size(); k++) {
					GameObject temp1 = objects.get(k);
					
					if (temp1.isEnemy == true) {
						if (temp1.collide().intersects(p.collide())) {
							state = false;
							finalScore = Score.score;
							return;
						}
					}

				
				}
			
			}
		}
	}
	
	/*
	 * restart method
	 * clears all objects
	 * (Minh Truong)
	 */
	public void restart() {
		this.objects.clear();
	}
	
	/*
	 * load method
	 * creates the objects
	 * (Minh Truong)
	 */
	public void load() {
		this.addObject(new Player(350, (int) Math.floor(Math.random() * (599 - 1)), false)); // creates the player
			
		for (int i = 0; i <= 25; i++) {
			this.addObject(new Enemy(0, (int) Math.floor(Math.random() * (599 - 1)), true)); // creates the wall of enemies - 25 in this version, might up it if the game is too easy.
		}
		
		this.finalScore = 0;
		Score.score = 0;
	}
	
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			
			temp.render(g);
		}
		
	}
	public boolean getState() {
		return state;
	}
	
	public void addObject(GameObject o) {
		this.objects.add(o);
	}

}
