import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Fleet {

	PApplet p;
	static final int rows = 5;
	static final int cols = 10;
	int speedUpdate = 40;
	int velocityX = 5;
	int velocityY = 1;
	int deltaX;
	int deltaY;

	List<SpaceInvader> invaders;

	public Fleet(PApplet p) {
		this.p = p;
		deltaX = p.width / 10 + 35;
		deltaY = p.height / 10 + 50;
		invaders = new ArrayList<SpaceInvader>();
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				invaders.add(createNewInvaders(i, j));
			}
		}
	}

	SpaceInvader createNewInvaders(int i, int j) {
		return new SpaceInvader(deltaX + (35 * i), deltaY + (30 * j),
				computeTypeFromRow(j), p);
	}
	
	void display(){
		System.out.println(invaders.size());
		invaders.forEach(i -> i.display());
	}

	private int computeTypeFromRow(int j) {
		switch (j) {
		case 0:
			return 1;
		case 1:
		case 2:
			return 2;
		default:
			return 3;
		}
	}

}
