import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 358011174883387846L;
	
	
	
	/// Variables for the Window Creation Method
	public int w = 800;
	public int h = 600;
	public String name = "APCS Final Project";
	
	
	
	// Thread + running boolean
	private boolean isRunning = false;
	private Thread thread;
	
	
	private Score score;
	
	// handler
	private Handler handler;
	
	
	//Starts everything required for 
	public Game() {
		handler = new Handler();
		new Window(w, h, name, this);
		score = new Score();
		this.addKeyListener(new GameListeners(handler));
		
		handler.addObject(new Player(350, (int) Math.floor(Math.random() * (599 - 1)), false));
		
		for (int i = 0; i <= 25; i++) {
			handler.addObject(new Enemy(0, (int) Math.floor(Math.random() * (599 - 1)), true));
		}
		

		

	}

	
	//Starts our thread
	public void start() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		
	}
	
	public void stop() {
		try {
			thread.join();
			isRunning = false;
			
		}
		catch (Exception e) {
			
		}
 	}


	public static void main(String[] args) {
		new Game();		
	}
	
	
	
	
	//The Following code is not my own, It is a publicly available game loop. The tick() and render() methods are partially mine. - nathaniel


	public void run() {
		this.requestFocus();
		 {
		        long lastTime = System.nanoTime();
		        double amountOfTicks = 60.0;
		        double ns = 1000000000 / amountOfTicks;
		        double delta = 0;
		        long timer = System.currentTimeMillis();
		        int frames = 0;
		        while(isRunning)
		        {
		        	
		        	//Loops 60 ticks each second, each tick the screen objects are updated.
		                    long now = System.nanoTime();
		                    delta += (now - lastTime) / ns;
		                    lastTime = now;
		                    while(delta >=1)
		                            {
		                                tick();
		                                delta--;
		                            }
		                            if(isRunning)
		                                render();
		                            frames++;
		                             
		                            /// this just prints the fps, though I commented out the actual print thing to display score
		                            if(System.currentTimeMillis() - timer > 1000)
		                            {
		                                timer += 1000;
		                                //System.out.println("FPS: "+ frames);
		                                frames = 0;
		                            }
		        }
		                stop();
		
		
		 }
	}
	private void tick() {
		handler.tick();
		handler.collision();
	    score.tick();
	}
	
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if (handler.getState() != false) {
		
		
		
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, w, h);
		handler.render(g);
		score.render(g);
		g.dispose();
		bs.show();
		}
		
		else {
		g.setColor(Color.black);
		g.fillRect(0, 0, w, h);
		g.dispose();
		
		Graphics g1 = bs.getDrawGraphics();

		g1.drawString("Score " + handler.finalScore, 350, 215);
		g1.setColor(Color.white);
		g1.dispose();
		
		Graphics g2 = bs.getDrawGraphics();
		g2.drawString("Game Over", 350, 200);
		g2.setColor(Color.white);
		g2.dispose();
		bs.show();
			
		}
		
	}
	
	public static int wall (int v, int max, int min) {
		if (v >= max) {
			return v = max;
		}
		else if (v <= min) {
			return v = min;
			
		}
		else {
			return v;
		}
	}

}
