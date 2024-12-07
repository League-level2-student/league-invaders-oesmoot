import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font enterFont;
    Timer frameDraw;
    Timer alienSpawn;
    RocketShip rocket = new RocketShip(250,700,50,50);
	ObjectManager objMan = new ObjectManager(rocket);
    public static BufferedImage image;
    public static boolean needImage = true;
    public static boolean gotImage = false;	
    boolean hasStarted = false;
    GamePanel() {
    	rocket.setObjMan(objMan);
    	titleFont = new Font("Arial",Font.PLAIN,48);
    	enterFont = new Font("Arial",Font.PLAIN,20);
    	frameDraw = new Timer(1000/60, this);
    	frameDraw.start();
    	if (needImage) {
    	    loadImage ("invaderBG.png");
    	}
    }
    void updateMenuState() {
    	
    }
    void updateGameState() {
    	rocket.updateRocket();
    	objMan.update();
    	if(!rocket.isActive) {
    		currentState = END;
    	}
    }
    void updateEndState() {
    	
    }
    void loadImage(String imageFile) {
        if (needImage) {
            try {
                image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
    	    gotImage = true;
            } catch (Exception e) {
                
            }
            needImage = false;
        }
    }
    
    public void startGame() {
    	if(!hasStarted) {
    		alienSpawn = new Timer(objMan.spawnSpeed , objMan);
    		hasStarted = true;
    	}
        alienSpawn.start();
    }
    
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.yellow);
    	g.drawString("garbag     invaderz", 20, 50);
    	g.setFont(enterFont);
    	g.drawString("press enter to start", 80, 300);
    	g.drawString("press space for instructions (you stupid idiot)", 80, 330);
    	}
    void drawGameState(Graphics g) {
    	if (gotImage) {
    		g.drawImage(image, 0,0, null);
    	}
    	objMan.draw(g);
    	g.setFont(enterFont);
    	g.drawString("score: " + String.valueOf(objMan.score), 5, 15);
    	g.drawString("ammo: " + String.valueOf(rocket.ammo), 150, 15);
    	alienSpawn.setDelay(objMan.spawnSpeed);
    }
    void drawEndState(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.blue);
    	g.drawString("Skill issue", 20,50);
    	g.setFont(enterFont);
    	g.drawString("press enter to play again", 80, 300);
    }
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		    if(currentState == GAME) {
		    	
		    	startGame();
		    	rocket.x = 200;
		    	rocket.y = 700;
		    	rocket.isActive = true;
		    	rocket.isMovingDown = false;
		    	rocket.isMovingLeft = false;
		    	rocket.isMovingRight = false;
		    	rocket.isMovingUp = false;
		    	rocket.isShooting = false; 
		    	objMan.spawnSpeed = 1000;
		    	objMan.projectiles.clear();
		    	objMan.aliens.clear();
		    }
		    if (currentState == END) {
		    	alienSpawn.stop();
		    }
		}
		if(currentState == GAME) {
			if (arg0.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			    rocket.isMovingUp = true;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("DOWN");
			    rocket.isMovingDown = true;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("LEFT");
			    rocket.isMovingLeft = true;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("RIGHT");
			    rocket.isMovingRight = true;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
				rocket.isShooting = true;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == GAME) {
			if (arg0.getKeyCode()==KeyEvent.VK_UP) {
			    rocket.isMovingUp = false;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocket.isMovingDown = false;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.isMovingLeft = false;
			}
			if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			    rocket.isMovingRight = false;
			}
			if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
				rocket.isShooting = false;
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
