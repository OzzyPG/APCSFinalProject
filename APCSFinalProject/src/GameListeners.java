import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameListeners extends KeyAdapter {
	
	
	private Handler handler;
	
	public GameListeners(Handler handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
				GameObject p = handler.objects.get(i);
				if (e.getKeyCode() == KeyEvent.VK_UP) {
				p.setSpeedY(-6);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					p.setSpeedY(6);
					
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					p.setSpeedX(-6);
			
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	
					p.setSpeedX(6);

				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					handler.restart();
					handler.state = true;
					handler.load();
				}
				
				
			}
		}	
		}
	
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
				GameObject p = handler.objects.get(i);
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

