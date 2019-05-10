import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

// So this class will do the rendering updates, object creation, etc.
//its kinda slow but it is okay for what we are doing for this project
public class Handler {
	
	private Game game;
	
	
	int req = 0;
	
	ArrayList<Color> colors = new ArrayList<Color>();	
	
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
	
	
	public void dead() {
		int players = -1;

		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			
			if (temp.isEnemy == false) {
				players++;
			}
		}
		if (players == -1) {
			state = false;
			finalScore = Score.score;
			return;
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
							p.setIsAlive(false);
							 objects.remove(p);
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
		colors.clear();
		colors.add(Color.cyan);
		colors.add(Color.blue);
		colors.add(Color.magenta);
		colors.add(Color.yellow);
                colors.add(Color.BLACK);
                colors.add(Color.GREEN);
                colors.add(Color.ORANGE);
                colors.add(Color.WHITE);


		for (int c = 1; c<= Game.players; c++) {
		this.addObject(new Player(450, (int) Math.floor(Math.random() * (599 - 1)), false, c, colors.get(c - 1), true)); // creates the player

		}
		//this.addObject(new Player(350, (int) Math.floor(Math.random() * (599 - 1)), false, 2, Color.BLUE)); // creates the player

			
		for (int i = 0; i <= 25; i++) {
			this.addObject(new Enemy(0, (int) Math.floor(Math.random() * (600 - 1)), true, 0, Color.red)); // creates the wall of enemies - 25 in this version, might up it if the game is too easy.
		}
		
		this.finalScore = 0;
		Score.score = 0;
	}
	
	public void wave(int f) {
		for (int i = 0; i <= f; i++) {
			this.addObject(new Enemy(0, (int) Math.floor(Math.random() * (600 - 1) + 10), true, 0, Color.red)); // creates the wall of enemies - 25 in this version, might up it if the game is too easy.
		}
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
