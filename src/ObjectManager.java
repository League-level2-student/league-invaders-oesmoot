import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
RocketShip rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random ran = new Random();
Iterator<Alien> iterA = aliens.iterator();
Iterator<Projectile> iterP = projectiles.iterator();
ObjectManager(RocketShip rocket){
	this.rocket = rocket;
}

public void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}

public void addAlien() {
	aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50));
}

public void update() {
	for(Alien a : aliens) {
		a.update();
		if(a.y>LeagueInvaders.HEIGHT) {
			a.isActive = false;
		}
	}
	for (Projectile p : projectiles) {
		p.update();
		if(p.y<0) {
			p.isActive = false;
		}
	}
}

public void draw(Graphics g) {
	rocket.draw(g);
	for(Alien a: aliens) {
		a.draw(g);
	}
	for (Projectile p: projectiles) {
		p.draw(g);
	}
}
public void purgeObjects() {
	while(iterA.hasNext()) {
		Alien a = iterA.next();
		if(!a.isActive) {
			iterA.remove();
		}
	}
	while(iterP.hasNext()) {
		Projectile p = iterP.next();
		if(!p.isActive) {
			iterP.remove();
		}
	}
}
}
