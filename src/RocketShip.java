import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RocketShip extends GameObject {
boolean isMovingUp = false;
boolean isMovingDown = false;
boolean isMovingLeft = false;
boolean isMovingRight = false;
boolean isShooting = false;
public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;	
int maxAmmo = 50;
int ammo = maxAmmo;
ObjectManager objMan;


	public void setObjMan(ObjectManager objMan) {
	this.objMan = objMan;
}
	RocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("hero.png");
		}
		// TODO Auto-generated constructor stub
	}
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}
	
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 30);
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
		if(isShooting) {
			if(ammo>=1) {
				objMan.addProjectile(getProjectile());
				ammo--;
			}
		}
		else {
			if(ammo<maxAmmo) {
				ammo+=5;
			}
		}
		
		super.update();
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
