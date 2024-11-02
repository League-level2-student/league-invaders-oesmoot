import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    RocketShip rocket = new RocketShip(250,700,50,50);
    GamePanel() {
    	titleFont = new Font("Arial",Font.PLAIN,48);
    	enterFont = new Font("Arial",Font.PLAIN,20);
    	frameDraw = new Timer(1000/60, this);
    	frameDraw.start();
    }
    void updateMenuState() {
    	
    }
    void updateGameState() {
    	
    }
    void updateEndState() {
    	
    }
    void drawMenuState(Graphics g) {
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	g.setFont(titleFont);
    	g.setColor(Color.yellow);
    	g.drawString("league invaderz", 20, 50);
    	g.setFont(enterFont);
    	g.drawString("press enter to start", 80, 300);
    	g.drawString("press space for instructions", 80, 330);
    	}
    void drawGameState(Graphics g) {
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
    	rocket.draw(g);
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
		}
		if(currentState == GAME) {
			if (arg0.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}
			if (arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("DOWN");
			}
			if (arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("LEFT");
			}
			if (arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("RIGHT");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}