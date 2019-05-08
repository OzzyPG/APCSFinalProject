import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameListeners extends KeyAdapter {
	
	
	private Handler handler;
	
	public GameListeners(Handler handler) {
		this.handler = handler;
	}
	
	/*
	 * keyPressed method
	 * takes in user input
	 * each button performs a certain action
	 * (Minh Truong)
	 */
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
				GameObject p = handler.objects.get(i);
				if (e.getKeyCode() == KeyEvent.VK_UP) {	//up arrow makes the object go up
				p.setSpeedY(-6);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {	//down arrow makes the object go down
					p.setSpeedY(6);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {	//left arrow makes object go left
					p.setSpeedX(-6);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	//right arrow makes object go right
					p.setSpeedX(6);

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {	//space bar restarts the game
					
					handler.restart();
					handler.state = true;
					handler.load();
					if (Game.startScr == true) {
						Game.startScr = false;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(1);
				}
				
				
			}
		}	
		}
	
	/*
	 * keyReleased method
	 * takes in user input
	 * each button performs a certain action
	 * (Minh Truong)
	 */
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
				GameObject p = handler.objects.get(i);
				//sets the x and y positions back to 0
				if (e.getKeyCode() == KeyEvent.VK_UP) {
				p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					p.setSpeedX(0);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	
					p.setSpeedX(0);

				}
				
			}
		}	
		
	}
	
	
}

