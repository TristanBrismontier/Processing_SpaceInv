import processing.core.PApplet;
import processing.core.PVector;

public class Laser extends Entity {

	float speedy;
	int type;
	boolean unedeux = true;

	Laser(float x_, float y_, PApplet p) {
		super(p, new PVector(x_, y_));
		super.setHitbox(new PVector(-3, -15), new PVector(8, 15));
		speedy = -2.5f;
		type = 2;
	}

	Laser(PApplet p, float x) {
		super(p, new PVector(x, 9 * p.height / 10));
		super.setHitbox(new PVector(-1, -10), new PVector(2, 10));
		speedy = 4;
		type = 1;
	}

	@Override
	public void display() {
		if (!aLive)
			return;
		p.stroke(255);
		if (type == 1) {
			p.strokeWeight(2);
			p.line(location.x, location.y, location.x, location.y - 10);
		} else {
			p.strokeWeight(2);
			p.line(location.x + 3, location.y, location.x - 3, location.y - 3);
			p.line(location.x - 3, location.y - 3, location.x + 3,location.y - 6);
			p.line(location.x + 3, location.y - 6, location.x - 3,location.y - 9);
			p.line(location.x - 3, location.y - 9, location.x + 3,location.y - 12);
			p.line(location.x + 3, location.y - 12, location.x - 3,location.y - 15);
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
