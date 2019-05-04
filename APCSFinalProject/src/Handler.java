import java.awt.Graphics;
import java.util.ArrayList;

// So this class will do the rendering updates, object creation, etc.
//its kinda slow but it is okay for what we are doing for this project
public class Handler {
	
	
	
	
	//updates and renders every game object, every tick.
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void tick() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);

			temp.tick();
		}
	}
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject temp = objects.get(i);
			
			temp.render(g);
		}
		
	}
	
	public void addObject(GameObject o) {
		this.objects.add(o);
	}

}
