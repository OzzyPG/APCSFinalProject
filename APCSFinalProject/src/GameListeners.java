import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameListeners extends KeyAdapter {
	
	
	private Handler handler;
	
	public GameListeners(Handler handler) {
		this.handler = handler;
	}
	
	int vel = 6;
	
	/*
	 * keyPressed method
	 * takes in user input
	 * each button performs a certain action
	 * (Minh Truong)
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_1) {
			Game.players = 1;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			Game.players = 2;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			Game.players = 4;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}

		}
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
				if (handler.objects.get(i).getPlayer() == 1) {
					GameObject p = handler.objects.get(i);

				if (e.getKeyCode() == KeyEvent.VK_UP) {	//up arrow makes the object go up
				p.setSpeedY(-vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {	//down arrow makes the object go down
					p.setSpeedY(vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {	//left arrow makes object go left
					p.setSpeedX(-vel);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	//right arrow makes object go right
					p.setSpeedX(vel);

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
				if (e.getKeyCode() == KeyEvent.VK_C) {
					vel = 3;
				}
				
				
			}
			
			else if (handler.objects.get(i).getPlayer() == 2) {
					GameObject p = handler.objects.get(i);

				if (e.getKeyCode() == KeyEvent.VK_W) {	//w makes the object go up
					p.setSpeedY(-vel);
						
					}
					if (e.getKeyCode() == KeyEvent.VK_S) {	//s makes the object go down
						p.setSpeedY(vel);
						
					}
					if (e.getKeyCode() == KeyEvent.VK_A) {	//a makes object go left
						p.setSpeedX(-vel);
				
					}
					if (e.getKeyCode() == KeyEvent.VK_D) {	//d makes object go right
						p.setSpeedX(vel);

					}
			}
			else if (handler.objects.get(i).getPlayer() == 3) {
				GameObject p = handler.objects.get(i);

			if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {	//w makes the object go up
				p.setSpeedY(-vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {	//s makes the object go down
					p.setSpeedY(vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {	//a makes object go left
					p.setSpeedX(-vel);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {	//d makes object go right
					p.setSpeedX(vel);

				}
		}
			else if (handler.objects.get(i).getPlayer() == 4) {
				GameObject p = handler.objects.get(i);

			if (e.getKeyCode() == KeyEvent.VK_I) {	//w makes the object go up
				p.setSpeedY(-vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_K) {	//s makes the object go down
					p.setSpeedY(vel);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_J) {	//a makes object go left
					p.setSpeedX(-vel);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_L) {	//d makes object go right
					p.setSpeedX(vel);

				}
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
				if (handler.objects.get(i).getPlayer() == 1) {
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
				if (e.getKeyCode() == KeyEvent.VK_C) {
					vel = 6;
				}
				
			}
		
			else if (handler.objects.get(i).getPlayer() == 2) {
				GameObject p = handler.objects.get(i);

			if (e.getKeyCode() == KeyEvent.VK_W) {	//w makes the object go up
				p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {	//s makes the object go down
					p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_A) {	//a makes object go left
					p.setSpeedX(0);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_D) {	//d makes object go right
					p.setSpeedX(0);

				}
		}
				
			else if (handler.objects.get(i).getPlayer() == 3) {
				GameObject p = handler.objects.get(i);

			if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {	//w makes the object go up
				p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {	//s makes the object go down
					p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {	//a makes object go left
					p.setSpeedX(0);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {	//d makes object go right
					p.setSpeedX(0);

				}
		}
			else if (handler.objects.get(i).getPlayer() == 4) {
				GameObject p = handler.objects.get(i);

			if (e.getKeyCode() == KeyEvent.VK_I) {	//w makes the object go up
				p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_K) {	//s makes the object go down
					p.setSpeedY(0);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_J) {	//a makes object go left
					p.setSpeedX(0);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_L) {	//d makes object go right
					p.setSpeedX(0);

				}
		}
			}
		}	
		
	}
	
	
}

