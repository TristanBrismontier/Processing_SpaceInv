import processing.core.PApplet;
import processing.core.PVector;

public class Laser extends Entity{
	
	float taille;
	boolean tire;
	float speedy;
	int type;
	boolean unedeux = true;

	Laser(float x_, float y_, PApplet p) {
		super(p, new PVector(x_, y_));
		super.setHitbox(new PVector(-3, -15), new PVector(8, 15));
		taille = 3;
		tire = false;
		speedy = -0.5f;
		type = 2;
	}

	Laser(PApplet p) {
		super(p, new PVector( p.width / 2, 9 * p.height / 10));
		super.setHitbox(new PVector(-1, -10), new PVector(2, 10));
		taille = 2;
		tire = false;
		speedy = 4.1f;
		type = 1;
	}

	  @Override
	   public void display() {
		if (tire == true) {
			if (type == 1) {
				p.strokeWeight(taille);
				p.stroke(255);
				p.line(location.x, location.y, location.x, location.y - 5 * taille);
			} else {
				p.strokeWeight(taille - 1);
				p.stroke(255);
				p.line(location.x + taille, location.y, location.x - taille, location.y - taille);
				p.line(location.x - taille, location.y - taille, location.x + taille, location.y - 2 * taille);
				p.line(location.x + taille, location.y - 2 * taille, location.x - taille, location.y - 3
						* taille);
				p.line(location.x - taille, location.y - 3 * taille, location.x + taille, location.y - 4
						* taille);
				p.line(location.x + taille, location.y - 4 * taille, location.x - taille, location.y - 5
						* taille);
			}
		}
		super.display();
	}

	void move() {
		if (tire == true) {
			location.y = location.y - speedy;
			if (location.y < 0 || location.y > p.height + 5 * taille) {
				location.x = 0;
				location.y = 0;
				tire = false;
			}
		}
	}

	void lancement(float x_) {
		if (tire == false) {
			tire = true;
			location.x = x_;
			if (unedeux == true) {
				location.y = 9 * p.height / 10;
				unedeux = !unedeux;
			} else {
				location.y = 9 * p.height / 10 - 2;
				unedeux = !unedeux;
			}

		}
	}

	void lancement(float x_, float y_) {
		if (tire == false) {
			tire = true;
			location.x = x_;
			location.y = y_;
		}
	}
}
