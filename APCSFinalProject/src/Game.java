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
	
	// handler
	private Handler handler;
	
	
	//Starts everything required for 
	public Game() {
		handler = new Handler();
		new Window(w, h, name, this);
		this.addKeyListener(new GameListeners(handler));
		
		handler.addObject(new Player(350, 275, false));

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
		                             
		                            /// this just prints the fps, not really needed.
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
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, w, h);
		handler.render(g);
		g.dispose();
		bs.show();
		
	}

}
