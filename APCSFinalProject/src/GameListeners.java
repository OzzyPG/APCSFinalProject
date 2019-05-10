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
		if (e.getKeyCode() == KeyEvent.VK_3) {
			Game.players = 3;
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
                if (e.getKeyCode() == KeyEvent.VK_5) {
			Game.players = 5;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}

		}
                if (e.getKeyCode() == KeyEvent.VK_6) {
			Game.players = 6;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}

		}
                if (e.getKeyCode() == KeyEvent.VK_7) {
			Game.players = 7;
			handler.restart();
			handler.state = true;
			handler.load();
			if (Game.startScr == true) {
				Game.startScr = false;
			}

		}
                if (e.getKeyCode() == KeyEvent.VK_8) {
			Game.players = 8;
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

                
		for (int i = 0; i < handler.objects.size(); i++) {
			if (handler.objects.get(i).getIsEnemy() == false) {
                            switch (handler.objects.get(i).getPlayer()) {
                                case 1:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_UP) {     //up arrow makes the object go up
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
                                        }       break;
                                    }
                                case 2:
                                    {
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
                                        break;
                                    }
                                case 3:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }
                                case 4:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_I) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_K) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_J) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_L) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }
                                    case 5:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_T) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_G) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_F) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_H) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }
                                    case 6:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_HOME) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_END) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_DELETE) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }
                                    case 7:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_0) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_P) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_O) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }
                                    case 8:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {	//w makes the object go up
                                            p.setSpeedY(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {	//s makes the object go down
                                            p.setSpeedY(vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {	//a makes object go left
                                            p.setSpeedX(-vel);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {	//d makes object go right
                                            p.setSpeedX(vel);
                                            
                                        }       break;
                                    }    
                                    
                                default:
                                    break;
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
                            switch (handler.objects.get(i).getPlayer()) {
                                case 1:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        //sets the x and y positions back to 0
                                        if (e.getKeyCode() == KeyEvent.VK_UP) {
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_RIGHT) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_C) {
                                            vel = 6;
                                        }       break;
                                    }
                                case 2:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_W) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_S) {
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_A) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_D) {
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                case 3:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD2) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD3) {	
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                case 4:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_I) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_K) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_J) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_L) {
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                    case 5:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_T) {
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_G) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_F) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_H) {	
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                    case 6:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_HOME) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_END) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_DELETE) {	
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {	
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                    case 7:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_0) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_P) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_O) {
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET) {	
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                    case 8:
                                    {
                                        GameObject p = handler.objects.get(i);
                                        if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {	
                                            p.setSpeedY(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                                            p.setSpeedX(0);
                                            
                                        }       if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {	
                                            p.setSpeedX(0);
                                            
                                        }       break;
                                    }
                                default:
                                    break;
                            }
			}
		}	
		
	}
	
	
}

