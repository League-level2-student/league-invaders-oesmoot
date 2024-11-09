import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
RocketShip rocket;
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ArrayList<Alien> aliens = new ArrayList<Alien>();
Random ran = new Random();
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
	
}
}
