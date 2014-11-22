import processing.core.PApplet;
import processing.core.PVector;

public class Laser extends Entity{
	
	float taille;
	float speedy;
	int type;
	boolean unedeux = true;

	Laser(float x_, float y_, PApplet p) {
		super(p, new PVector(x_, y_));
		super.setHitbox(new PVector(-3, -15), new PVector(8, 15));
		taille = 3;
		speedy = -0.5f;
		type = 2;
	}

	Laser(PApplet p, float x) {
		super(p, new PVector( x, 9 * p.height / 10));
		super.setHitbox(new PVector(-1, -10), new PVector(2, 10));
		taille = 2;
		speedy = 4.1f;
		type = 1;
	}

	  @Override
	   public void display() {
		  if(!aLive) return;
		  p.stroke(255);
			if (type == 1) {
				p.strokeWeight(taille);
				p.line(location.x, location.y, location.x, location.y - 5 * taille);
			} else {
				p.strokeWeight(taille - 1);
				p.line(location.x + taille, location.y, location.x - taille, location.y - taille);
				p.line(location.x - taille, location.y - taille, location.x + taille, location.y - 2 * taille);
				p.line(location.x + taille, location.y - 2 * taille, location.x - taille, location.y - 3
						* taille);
				p.line(location.x - taille, location.y - 3 * taille, location.x + taille, location.y - 4
						* taille);
				p.line(location.x + taille, location.y - 4 * taille, location.x - taille, location.y - 5
						* taille);
			}
		super.display();
	}

	void update() {
			location.y = location.y - speedy;
			if (location.y < 0 || location.y > p.height + 15) {
				aLive = false;
		}
	}
}
