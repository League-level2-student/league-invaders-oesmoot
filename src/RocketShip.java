import java.awt.Color;
import java.awt.Graphics;

public class RocketShip extends GameObject {
boolean isMovingUp = false;
boolean isMovingDown = false;
boolean isMovingLeft = false;
boolean isMovingRight = false;
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
	void updateRocket() {
		if(isMovingUp) {
			if(y> (-50)) {
			   up();	
		    }
		}
		if(isMovingDown) {
			 if(y< 800) {
				down();
			    }
		}
		if(isMovingLeft) {
			if (x>(-50)) {
		    	left();
		    }
		}
		if(isMovingRight) {
			if(x<500) {
				right();
		    }
		}
	}
	
	public void up() {
		y -= speed;
	}
	public void down() {
		y += speed;
	}
	public void left() {
		x -= speed;
	}
	public void right() {
		x += speed;
	}

}
