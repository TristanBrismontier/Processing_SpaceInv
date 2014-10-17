import processing.core.PApplet;
import processing.core.PVector;

public class SpaceInvader extends Entity{
	int type;
	int taillex;
	int tailley;
	float speedx;
	int speedy;
	boolean existe;
	boolean fspY = false;

	SpaceInvader(int X_, int Y_, int _type, PApplet p) {
		super(p, new PVector(X_, X_));
		super.setHitbox(new PVector(-12, -8), new PVector(24, 16));
		this.p = p;
		type = _type;
		

		existe = true;

		speedy = 1;
		speedx = 5;

		taillex = 2;
		tailley = 2;

	}

	 void display(boolean flag) {
		float spX = location.x;
		float spY = location.y;
		if (existe == true) {
			if (type == 1) {

				p.noStroke();
				p.fill(255);
				p.rectMode(p.CORNER);
				p.rect(-2 * taillex + spX, -4 * tailley + spY, 4 * taillex,tailley);
				p.rect(-5 * taillex + spX, -3 * tailley + spY, 10 * taillex,tailley);
				p.rect(-6 * taillex + spX, -2 * tailley + spY, 12 * taillex,tailley);
				p.rect(-6 * taillex + spX, -1 * tailley + spY, 3 * taillex,tailley);
				p.rect(-1 * taillex + spX, -1 * tailley + spY, 2 * taillex,tailley);
				p.rect(3 * taillex + spX, -1 * tailley + spY, 3 * taillex,tailley);
				p.rect(-6 * taillex + spX, spY, 12 * taillex, tailley);
				p.rect(1 * taillex + spX, 1 * tailley + spY, 2 * taillex,tailley);
				p.rect(-3 * taillex + spX, 1 * tailley + spY, 2 * taillex,tailley);
				p.rect(-1 * taillex + spX, 2 * tailley + spY, 2 * taillex,tailley);

				if (flag == false) {
					p.rect(-4 * taillex + spX, 2 * tailley + spY, 2 * taillex,tailley);
					p.rect(2 * taillex + spX, 2 * tailley + spY, 2 * taillex,tailley);
					p.rect(-6 * taillex + spX, 3 * tailley + spY, 2 * taillex,tailley);
					p.rect(4 * taillex + spX, 3 * tailley + spY, 2 * taillex,tailley);
				} else {
					p.rect(-5 * taillex + spX, 2 * tailley + spY, 2 * taillex,tailley);
					p.rect(3 * taillex + spX, 2 * tailley + spY, 2 * taillex,tailley);
					p.rect(-4 * taillex + spX, 3 * tailley + spY, 2 * taillex,tailley);
					p.rect(2 * taillex + spX, 3 * tailley + spY, 2 * taillex,tailley);
				}

			}
			if (type == 2) {
				p.noStroke();
				p.fill(255);
				p.rectMode(p.CORNER);
				p.rect(-3.5f * taillex + spX, -5.0f * tailley + spY,1 * taillex, 1 * tailley);
				p.rect(2.5f * taillex + spX, -5.0f * tailley + spY,1 * taillex, 1 * tailley);
				p.rect(-2.5f * taillex + spX, -4.0f * tailley + spY,1 * taillex, 1 * tailley);
				p.rect(1.5f * taillex + spX, -4.0f * tailley + spY,1 * taillex, 1 * tailley);
				p.rect(-3.5f * taillex + spX, -3.0f * tailley + spY,7 * taillex, 1 * tailley);
				p.rect(-3.5f * taillex + spX, -3.0f * tailley + spY,1 * taillex, 5 * tailley);
				p.rect(2.5f * taillex + spX, -3.0f * tailley + spY,1 * taillex, 5 * tailley);
				p.rect(-3.5f * taillex + spX, -1.0f * tailley + spY,7 * taillex, 2 * tailley);
				p.rect(-1.5f * taillex + spX, -2.0f * tailley + spY,3 * taillex, 1 * tailley);
				p.rect(-4.5f * taillex + spX, -2.0f * tailley + spY,1 * taillex, 2 * tailley);
				p.rect(3.5f * taillex + spX, -2.0f * tailley + spY,1 * taillex, 2 * tailley);
				if (flag == false) {
					p.rect(-5.5f * taillex + spX, -1.0f * tailley + spY,1 * taillex, 3 * tailley);
					p.rect(4.5f * taillex + spX, -1.0f * tailley + spY,1 * taillex, 3 * tailley);
					p.rect(.5f * taillex + spX, 2.0f * tailley + spY,2 * taillex, 1 * tailley);
					p.rect(-2.5f * taillex + spX, 2.0f * tailley + spY,2 * taillex, 1 * tailley);
				} else {
					p.rect(-5.5f * taillex + spX, -4.0f * tailley + spY,1 * taillex, 3 * tailley);
					p.rect(4.5f * taillex + spX, -4.0f * tailley + spY,1 * taillex, 3 * tailley);
					p.rect(3.5f * taillex + spX, 2.0f * tailley + spY,1 * taillex, 1 * tailley);
					p.rect(-4.5f * taillex + spX, 2.0f * tailley + spY,1 * taillex, 1 * tailley);
				}
			}
			if (type == 3) {
				p.noStroke();
				p.fill(255);
				p.rectMode(p.CORNER);
				p.rect(-1 * taillex + spX, -3 * tailley + spY, 2 * taillex,tailley);
				p.rect(-2 * taillex + spX, -2 * tailley + spY, 4 * taillex,tailley);
				p.rect(-3 * taillex + spX, -1 * tailley + spY, 6 * taillex,tailley);
				p.rect(-4 * taillex + spX, spY, 2 * taillex, tailley);
				p.rect(-1 * taillex + spX, spY, 2 * taillex, tailley);
				p.rect(2 * taillex + spX, spY, 2 * taillex, tailley);
				p.rect(-4 * taillex + spX, 1 * tailley + spY, 8 * taillex,tailley);
				p.rect(-2 * taillex + spX, 2 * tailley + spY, taillex, tailley);
				p.rect(taillex + spX, 2 * tailley + spY, taillex, tailley);
				p.rect(-3 * taillex + spX, 3 * tailley + spY, taillex, tailley);
				p.rect(2 * taillex + spX, 3 * tailley + spY, taillex, tailley);
				p.rect(-2 * taillex + spX, 4 * tailley + spY, taillex, tailley);
				p.rect(taillex + spX, 4 * tailley + spY, taillex, tailley);
				p.rect(-2 * taillex + spX, 4 * tailley + spY, taillex, tailley);
				p.rect(taillex + spX, 4 * tailley + spY, taillex, tailley);

				if (flag == false) {
					p.rect(-4 * taillex + spX, 4 * tailley + spY, taillex,tailley);
					p.rect(3 * taillex + spX, 4 * tailley + spY, taillex,tailley);
					p.rect(-1 * taillex + spX, 3 * tailley + spY, 2 * taillex,tailley);
				}

			}
		}
		super.display();
	}

	boolean move(float signe, boolean fpY) {

		if (fpY != fspY) {
			location.y = location.y + 10;
			fspY = fpY;
			return false;
		} else {
			// float speedxt = speedx * signe;
			location.x = location.x + signe;
			if (existe == true) {
				if (location.x > 14 * p.width / 15) {
					return true;
				} else {
					return location.x < p.width / 15;
				}
			} else {
				return false;
			}
		}
	}

	boolean contact(float x_, float y_) {
		if (existe == true) {
			if (x_ < 4.5 * taillex + location.x + taillex
					&& x_ > -4.5 * taillex + location.x - taillex
					&& y_ > -5.0 * tailley + location.x && y_ < 2.0 * tailley + location.y) {
				existe = false;

			}
			return existe;
		} else {
			return true;
		}
	}
}
