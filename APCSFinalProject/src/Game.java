import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 358011174883387846L;
	
	
	
	/// Variables for the Window Creation Method
	public int w = 800; // width
	public int h = 600; // height
	public String name = "APCS Final Project";
	
	
	
	// Thread + running boolean
	public static boolean isRunning = false;
	private Thread thread;
	
	// score
	private Score score;
	
	// handler
	private Handler handler;
	
	
	//Starts everything required for 
	public Game() {
		handler = new Handler(); // initialized handler
		new Window(w, h, name, this); // creates the main game windoe
		score = new Score(); // initialized score
		this.addKeyListener(new GameListeners(handler)); // allows the program to read key inputs
		
		handler.load();
		

		

	}

	
	//Starts our thread
	public void start() {
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		
	}
	
	//stops the thread if possible, does nothing if impossible. 
	public void stop() {
		try {
			thread.join();
			isRunning = false;
			
		}
		catch (Exception e) {
			
		}
 	}
	
	
	
	

	// starts the process of starting
	public static void main(String[] args) {
		new Game();		
	}
	
	
	
	
	//The Following code is not my own, It is a publicly available game loop. The tick() and render() methods are partially mine. - nathaniel
	// inline comments are mine

	public void run() {
		this.requestFocus(); // makes it so you dont have to click to move
		 {
		        long lastTime = System.nanoTime(); // stores a time
		        double amountOfTicks = 60.0; // ticks per second
		        double ns = 1000000000 / amountOfTicks; // ticks per nanosecond
		        double delta = 0; // delta
		        long timer = System.currentTimeMillis(); // current time in milliseconds
		        int frames = 0; // frames
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
		g.setColor(Color.pink);
		g.fillRect(0, 0, w, h);
		g.dispose();
		
		Graphics g1 = bs.getDrawGraphics();

		
		
		g1.setColor(Color.white);
		g1.setFont(new Font("arial",Font.BOLD,20));
		g1.drawString("Score " + handler.finalScore, 350, 215);
		g1.dispose();
		
		Graphics g2 = bs.getDrawGraphics();
		
		
		g2.setColor(Color.white);
		g2.setFont(new Font("arial",Font.BOLD,20));
		
		g2.drawString("Game Over", 350, 190);
		g2.dispose();
		
		
		Graphics g3 = bs.getDrawGraphics();
		
		g3.setColor(Color.white);
		g3.setFont(new Font("arial",Font.BOLD,20));
	
		g3.drawString("Press Space to restart", 320, 250);
		g3.dispose();
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
