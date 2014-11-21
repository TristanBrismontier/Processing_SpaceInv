import processing.core.PApplet;
import processing.core.PVector;

public class SpaceInvader extends Entity {
	int type;
	boolean fspY = false;
	boolean flag = true;

	SpaceInvader(int X_, int Y_, int _type, PApplet p) {
		super(p, new PVector(X_, X_));
		super.setHitbox(new PVector(-12, -8), new PVector(24, 16));
		this.p = p;
		type = _type;
	}

	@Override
	public void display() {
		float spX = location.x;
		float spY = location.y;
		flag = !flag;
		if (type == 1) {

			p.noStroke();
			p.fill(255);
			p.rectMode(p.CORNER);
			p.rect(-2 * 2 + spX, -4 * 2 + spY, 4 * 2, 2);
			p.rect(-5 * 2 + spX, -3 * 2 + spY, 10 * 2, 2);
			p.rect(-6 * 2 + spX, -2 * 2 + spY, 12 * 2, 2);
			p.rect(-6 * 2 + spX, -1 * 2 + spY, 3 * 2, 2);
			p.rect(-1 * 2 + spX, -1 * 2 + spY, 2 * 2, 2);
			p.rect(3 * 2 + spX, -1 * 2 + spY, 3 * 2, 2);
			p.rect(-6 * 2 + spX, spY, 12 * 2, 2);
			p.rect(1 * 2 + spX, 1 * 2 + spY, 2 * 2, 2);
			p.rect(-3 * 2 + spX, 1 * 2 + spY, 2 * 2, 2);
			p.rect(-1 * 2 + spX, 2 * 2 + spY, 2 * 2, 2);

			if (flag == false) {
				p.rect(-4 * 2 + spX, 2 * 2 + spY, 2 * 2, 2);
				p.rect(2 * 2 + spX, 2 * 2 + spY, 2 * 2, 2);
				p.rect(-6 * 2 + spX, 3 * 2 + spY, 2 * 2, 2);
				p.rect(4 * 2 + spX, 3 * 2 + spY, 2 * 2, 2);
			} else {
				p.rect(-5 * 2 + spX, 2 * 2 + spY, 2 * 2, 2);
				p.rect(3 * 2 + spX, 2 * 2 + spY, 2 * 2, 2);
				p.rect(-4 * 2 + spX, 3 * 2 + spY, 2 * 2, 2);
				p.rect(2 * 2 + spX, 3 * 2 + spY, 2 * 2, 2);
			}
		}
		if (type == 2) {
			p.noStroke();
			p.fill(255);
			p.rectMode(p.CORNER);
			p.rect(-3.5f * 2 + spX, -5.0f * 2 + spY, 1 * 2, 1 * 2);
			p.rect(2.5f * 2 + spX, -5.0f * 2 + spY, 1 * 2, 1 * 2);
			p.rect(-2.5f * 2 + spX, -4.0f * 2 + spY, 1 * 2, 1 * 2);
			p.rect(1.5f * 2 + spX, -4.0f * 2 + spY, 1 * 2, 1 * 2);
			p.rect(-3.5f * 2 + spX, -3.0f * 2 + spY, 7 * 2, 1 * 2);
			p.rect(-3.5f * 2 + spX, -3.0f * 2 + spY, 1 * 2, 5 * 2);
			p.rect(2.5f * 2 + spX, -3.0f * 2 + spY, 1 * 2, 5 * 2);
			p.rect(-3.5f * 2 + spX, -1.0f * 2 + spY, 7 * 2, 2 * 2);
			p.rect(-1.5f * 2 + spX, -2.0f * 2 + spY, 3 * 2, 1 * 2);
			p.rect(-4.5f * 2 + spX, -2.0f * 2 + spY, 1 * 2, 2 * 2);
			p.rect(3.5f * 2 + spX, -2.0f * 2 + spY, 1 * 2, 2 * 2);
			if (flag == false) {
				p.rect(-5.5f * 2 + spX, -1.0f * 2 + spY, 1 * 2, 3 * 2);
				p.rect(4.5f * 2 + spX, -1.0f * 2 + spY, 1 * 2, 3 * 2);
				p.rect(.5f * 2 + spX, 2.0f * 2 + spY, 2 * 2, 1 * 2);
				p.rect(-2.5f * 2 + spX, 2.0f * 2 + spY, 2 * 2, 1 * 2);
			} else {
				p.rect(-5.5f * 2 + spX, -4.0f * 2 + spY, 1 * 2, 3 * 2);
				p.rect(4.5f * 2 + spX, -4.0f * 2 + spY, 1 * 2, 3 * 2);
				p.rect(3.5f * 2 + spX, 2.0f * 2 + spY, 1 * 2, 1 * 2);
				p.rect(-4.5f * 2 + spX, 2.0f * 2 + spY, 1 * 2, 1 * 2);
			}
		}
		if (type == 3) {
			p.noStroke();
			p.fill(255);
			p.rectMode(p.CORNER);
			p.rect(-1 * 2 + spX, -3 * 2 + spY, 2 * 2, 2);
			p.rect(-2 * 2 + spX, -2 * 2 + spY, 4 * 2, 2);
			p.rect(-3 * 2 + spX, -1 * 2 + spY, 6 * 2, 2);
			p.rect(-4 * 2 + spX, spY, 2 * 2, 2);
			p.rect(-1 * 2 + spX, spY, 2 * 2, 2);
			p.rect(2 * 2 + spX, spY, 2 * 2, 2);
			p.rect(-4 * 2 + spX, 1 * 2 + spY, 8 * 2, 2);
			p.rect(-2 * 2 + spX, 2 * 2 + spY, 2, 2);
			p.rect(2 + spX, 2 * 2 + spY, 2, 2);
			p.rect(-3 * 2 + spX, 3 * 2 + spY, 2, 2);
			p.rect(2 * 2 + spX, 3 * 2 + spY, 2, 2);
			p.rect(-2 * 2 + spX, 4 * 2 + spY, 2, 2);
			p.rect(2 + spX, 4 * 2 + spY, 2, 2);
			p.rect(-2 * 2 + spX, 4 * 2 + spY, 2, 2);
			p.rect(2 + spX, 4 * 2 + spY, 2, 2);

			if (flag == false) {
				p.rect(-4 * 2 + spX, 4 * 2 + spY, 2, 2);
				p.rect(3 * 2 + spX, 4 * 2 + spY, 2, 2);
				p.rect(-1 * 2 + spX, 3 * 2 + spY, 2 * 2, 2);
			}

		}
		super.display();
	}

	boolean move(float signe) {
		location.x = location.x + signe;

		if (location.x > 14 * p.width / 15) {
			return true;
		} else {
			return location.x < p.width / 15;
		}
	}

}
