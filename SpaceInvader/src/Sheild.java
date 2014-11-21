import processing.core.PApplet;
import processing.core.PVector;

public class Sheild extends Entity {

	int taillex, tailley;
	int[][] protect = {
			{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 } };

	Sheild(int x_, int y_, PApplet p) {
		super(p, new PVector(x_, y_));
		super.setHitbox(new PVector(-1, -1), new PVector(40, 30));
		taillex = 2;
		tailley = 2;
	}

	  @Override
	   public void display() {

		p.noStroke();
		p.fill(0, 255, 0);
		p.rectMode(p.CENTER);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 20; j++) {
				if (protect[i][j] == 1) {
					p.rect(j * taillex + location.x, i * tailley + location.y, taillex, tailley);
				}
			}
		}
		super.display();
	}

	boolean contact(float pX, float pY) {
		boolean flagtouch = false;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 20; j++) {
				if (pX >= j * taillex + location.x - taillex / 2
						&& pX <= j * taillex + location.x + tailley / 2
						&& pY >= i * tailley + location.y - tailley / 2
						&& pY <= i * tailley + location.y + tailley / 2
						&& protect[i][j] == 1) {
					protect[i][j] = 0;
					for (int t = i - 2; t <= i + 2; t++) {
						for (int r = j - 2; r <= j + 2; r++) {
							if (t >= 0 && t < 15 && r >= 0 && r < 20) {
								if (p.random(100) > 75) {
									protect[t][r] = 0;
								}
							}
						}
					}
					flagtouch = true;
				}
			}
		}
		return flagtouch;
	}

}
