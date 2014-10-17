import processing.core.PApplet;
import processing.core.PVector;

public class MotherShip extends Entity{


	int taillex;
	int tailley;
	float speedx;
	boolean existe;
	boolean sens;


	MotherShip(PApplet p) {
		
		super(p, new PVector(p.width / 2, 65));
		super.setHitbox(new PVector(-16, -6), new PVector(32, 12));
		existe = false;
		speedx = 1;
		taillex = 2;
		tailley = 2;
	}

	  @Override
	   public void display() {
		if (existe == true) {

			p.noStroke();
			p.fill(255, 10, 10);
			p.rectMode(p.CORNER);
			p.rect(-3 * taillex + location.x, -3 * tailley + location.y, 6 * taillex, tailley);
			p.rect(-5 * taillex + location.x, -2 * tailley + location.y, 10 * taillex,
					tailley);
			p.rect(-6 * taillex + location.x, -1 * tailley + location.y, 12 * taillex,
					tailley);
			p.rect(-7 * taillex + location.x, 0 * tailley + location.y, 2 * taillex, tailley);
			p.rect(-4 * taillex + location.x, 0 * tailley + location.y, 2 * taillex, tailley);
			p.rect(-1 * taillex + location.x, 0 * tailley + location.y, 2 * taillex, tailley);
			p.rect(2 * taillex + location.x, 0 * tailley + location.y, 2 * taillex, tailley);
			p.rect(5 * taillex + location.x, 0 * tailley + location.y, 2 * taillex, tailley);
			p.rect(-8 * taillex + location.x, 1 * tailley + location.y, 16 * taillex, tailley);
			p.rect(-6 * taillex + location.x, 2 * tailley + location.y, 3 * taillex, tailley);
			p.rect(-1 * taillex + location.x, 2 * tailley + location.y, 2 * taillex, tailley);
			p.rect(3 * taillex + location.x, 2 * tailley + location.y, 3 * taillex, tailley);
			p.rect(-5 * taillex + location.x, 3 * tailley + location.y, 1 * taillex, tailley);
			p.rect(4 * taillex + location.x, 3 * tailley + location.y, 1 * taillex, tailley);

		}
		super.display();
	}

	void lancement(float k) {
		if (k < 1) {

			location.x = -7 * taillex;
			sens = true;
		} else {
			location.x = p.width + 7 * taillex;
			sens = false;
		}
		speedx = p.random(0.8f, 2);
		existe = true;
	}

	void move() {
		if (location.x + 8 * taillex > 0 && location.x - 8 * taillex < p.width) {
			if (sens == true) {
				location.x = location.x + speedx;
			} else {

				location.x = location.x - speedx;
			}
		} else {
			existe = false;
		}
	}

	boolean contact(float x_, float y_) {
		if (existe == true) {
			if (x_ < location.x + 8 * taillex && x_ > location.x - 8 * taillex
					&& y_ > -3 * tailley + location.y && y_ < 3 * tailley + location.y) {
				existe = false;

			}
			return existe;
		} else {
			return true;
		}
	}
}
