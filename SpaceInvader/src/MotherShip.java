import processing.core.PApplet;
import processing.core.PVector;

public class MotherShip extends Entity {
	int taillex;
	int tailley;
	float speedx;

	MotherShip(PApplet p) {
		super(p, new PVector(p.width / 2, 65));
		super.setHitbox(new PVector(-16, -6), new PVector(32, 12));
		aLive = false;
		speedx = 1;
		taillex = 2;
		tailley = 2;
	}

	@Override
	public void display() {
		if (aLive == true) {
			p.noStroke();
			p.fill(255, 10, 10);
			p.rectMode(p.CORNER);
			p.rect(-3 * taillex + location.x, -3 * tailley + location.y,
					6 * taillex, tailley);
			p.rect(-5 * taillex + location.x, -2 * tailley + location.y,
					10 * taillex, tailley);
			p.rect(-6 * taillex + location.x, -1 * tailley + location.y,
					12 * taillex, tailley);
			p.rect(-7 * taillex + location.x, 0 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(-4 * taillex + location.x, 0 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(-1 * taillex + location.x, 0 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(2 * taillex + location.x, 0 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(5 * taillex + location.x, 0 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(-8 * taillex + location.x, 1 * tailley + location.y,
					16 * taillex, tailley);
			p.rect(-6 * taillex + location.x, 2 * tailley + location.y,
					3 * taillex, tailley);
			p.rect(-1 * taillex + location.x, 2 * tailley + location.y,
					2 * taillex, tailley);
			p.rect(3 * taillex + location.x, 2 * tailley + location.y,
					3 * taillex, tailley);
			p.rect(-5 * taillex + location.x, 3 * tailley + location.y,
					1 * taillex, tailley);
			p.rect(4 * taillex + location.x, 3 * tailley + location.y,
					1 * taillex, tailley);
		}
		super.display();
	}

	void launchMotherShip(boolean k) {
		if (k) {
			location.x = -7 * taillex;
			speedx = p.random(0.8f, 2);
		} else {
			location.x = p.width + 7 * taillex;
			speedx = - p.random(0.8f, 2);
		}
		aLive = true;
	}

	void update() {
		if (location.x + 8 * taillex > 0 && location.x - 8 * taillex < p.width) {
				location.x = location.x + speedx;
		} else {
			aLive = false;
		}
	}
	
	int checkContact(Laser laser){
		if(contact(laser)){
			laser.setaLive(false);
			setaLive(false);
			return 100;
		}
		return 0;
	}

}
