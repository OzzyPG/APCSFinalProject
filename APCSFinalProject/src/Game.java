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
	
	
	
	
	public static int players;
	
	
	
	// Thread + running boolean
	public static boolean isRunning = false;
	private Thread thread;
	private Thread thread2;
	
	// score
	private Score score;
	public static boolean startScr =  true;
	
	// handler
	private Handler handler;
	
	
	//Starts everything required for 
	public Game() {
		handler = new Handler(); // initialized handler
		new Window(w, h, name, this); // creates the main game windoe
		score = new Score(handler); // initialized score
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
		                                System.out.println("FPS: "+ frames);
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
	    if (handler.getState() == true) {
	    handler.dead();
	    }
	}
	
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if (startScr) {
			Graphics g4 = bs.getDrawGraphics();
			g4.setColor(Color.pink);
			g4.fillRect(0, 0, w, h);
			
			
			g4.setColor(Color.white);
			g4.setFont(new Font("arial",Font.BOLD,20));
		
			g4.drawString("Press Space to start", 300, 250);
			
			g4.drawString("Use Arrow Keys to move", 300, 290);

			
			g4.dispose();
			bs.show();
				
			
			

		}
		
		else if (handler.getState() != false) {
		
		
		
		
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
		g1.drawString("Score " + handler.finalScore, 345, 215);
     	g1.drawString("Game Over", 345, 190);
		g1.drawString("Press Space to restart", 300, 260);
		g1.drawString("Press Escape to Exit", 300, 300);
		g1.dispose();
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
