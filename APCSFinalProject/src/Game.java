import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;





//////// Nathaniel 


public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 358011174883387846L;
	
	
	
	/// Variables for the Window Creation Method
	public int w = 800; // width
	public int h = 600; // height
	public String name = "Got To Go Fast";
	
	
	
	
	public static int players;
	
	
	
	// Thread + running boolean
	public static boolean isRunning = false;
	private Thread thread;
	
	
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
	
	/**
	 * Handles each tick - Updates and checks for collision for each object. Also updates score
	 */
	private void tick() {
		handler.tick();
		handler.collision();
	    score.tick();
	    if (handler.getState() == true) {
	    handler.dead();
	    }
	}
	
	
	
	//renders graphics on the screen each tick
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		if (startScr) {
			
			
			
			
			
			
			
			
			//////// Minh
			Graphics g4 = bs.getDrawGraphics();
			g4.setColor(Color.pink);
			g4.fillRect(0, 0, w, h);
			
			
			g4.setColor(Color.white);
			g4.setFont(new Font("arial",Font.BOLD,20));
		
			g4.drawString("Press a number 1-8 for the number of players to start", 150, 200);
			
            g4.setFont(new Font("Georgia", Font.BOLD, 20));
			g4.drawString("1: Cyan: Use Arrow Keys to move", 150, 230);
            g4.drawString("2: Blue: Use WASD Keys to move", 150, 260);
            g4.drawString("3: Magenta: Use NUMPAD 5 2 1 3 Keys to move", 150, 290);
            g4.drawString("4: Yellow: Use I J K L to move", 150, 320);
            g4.drawString("5: Black: Use T F G H to move", 150, 350);
            g4.drawString("6: Green: Use HOME DELETE END PAGEDOWN to move", 150, 380);
            g4.drawString("7: Orange: Use Zero O P LEFT BRACKET to move", 150, 410);
            g4.drawString("8: White: Use NUMPAD DIVIDE 7 8 9 to move", 150, 440);

			
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
	                
	                g1.drawString("Game Over", 150, 120);
			g1.drawString("Score " + handler.finalScore, 150, 155);
	
	        g1.setFont(new Font("Georgia", Font.BOLD, 20));
	        g1.drawString("Press a number 1-8 for the number of players to start", 150, 200);
	
	        g1.drawString("1: Cyan: Use Arrow Keys to move", 150, 230);
	        g1.drawString("2: Blue: Use WASD Keys to move", 150, 260);
	        g1.drawString("3: Magenta: Use NUMPAD 5 1 2 3 Keys to move", 150, 290);
	        g1.drawString("4: Yellow: Use I J K L to move", 150, 320);
	        g1.drawString("5: Black: Use T F G H to move", 150, 350);
	        g1.drawString("6: Green: Use HOME DELETE END PAGEDOWN to move", 150, 380);
	        g1.drawString("7: Orange: Use Zero O P LEFT BRACKET to move", 150, 410);
	        g1.drawString("8: White: Use NUMPAD DIVIDE 7 8 9 to move", 150, 440);
	        
	        g1.setFont(new Font("arial",Font.BOLD,20));
			g1.drawString("Press Escape to Exit", 150, 500);
			g1.dispose();
			bs.show();
			
		}
		
	}
	
	
	
	
	
	/////// Sameer + nathaniel
	
	
	/**
	 * MAkes it so that the player cannot go out of bounds
	 * @param v position
	 * @param max wall y
	 * @param min wall x
	 * @return new position
	 */
	
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
