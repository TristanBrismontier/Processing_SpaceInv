import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import processing.core.PApplet;

public class Fleet {

	PApplet p;
	static final int rows = 5;
	static final int cols = 10;
	static final int maxInvadersLazer = 3;
	boolean positionFlag;
	boolean boundaryContact = false;
	int speedUpdate = 40;
	float velocityX = 5;
	int velocityY = 5;
	int deltaX;
	int deltaY;

	List<SpaceInvader> invaders;
	List<Laser> lasers;

	public Fleet(PApplet p) {
		this.p = p;
		deltaX = p.width / 10 + 35;
		deltaY = p.height / 10 + 200;
		invaders = new ArrayList<SpaceInvader>();
		lasers = new ArrayList<Laser>();
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

	void update() {
		updateLasers();
		if (p.frameCount % speedUpdate != 0)
			return;
		shotLaser();
		positionFlag = !positionFlag;
		if (boundaryContact) {
			boundaryContact = false;
			invaders.forEach(i -> i.moveY(velocityY));
			return;
		}
		for (SpaceInvader spaceInvader : invaders) {
			if (spaceInvader.moveX(velocityX)) {
				boundaryContact = true;
			}
		}

		if (boundaryContact)
			maneuveFleet();
	}

	private void updateLasers() {
		Iterator<Laser> laserIt = lasers.iterator();
		while (laserIt.hasNext()) {
			Laser laser = laserIt.next();
			laser.update();
			if (!laser.aLive) {
				laserIt.remove();
			}
		}
	}

	private void shotLaser() {
		if (lasers.size() >= maxInvadersLazer)
			return;
		if (p.random(100) <= 75)
			return;

		int randomInvaderIndex = (int) p.random(invaders.size()) - 1;
		randomInvaderIndex = p.constrain(randomInvaderIndex, 0,
				invaders.size() - 1);
		SpaceInvader shootingInvader = invaders.get(randomInvaderIndex);

		lasers.add(new Laser(shootingInvader.location.x,
				shootingInvader.location.y, p));
	}

	private void maneuveFleet() {
		speedUpdate -= 3;
		speedUpdate = p.constrain(speedUpdate, 6, 60);
		if (velocityX > 0) {
			velocityX = velocityX * -1 - 0.3f;
		} else {
			velocityX = velocityX * -1 + 0.3f;
		}
		velocityX = p.constrain(velocityX, -14, 14);
	}

	void display() {
		invaders.forEach(i -> i.display(positionFlag));
		lasers.forEach(l -> l.display());
	}

	private int computeTypeFromRow(int j) {
		switch (j) {
		case 0:
			return 3;
		case 1:
		case 2:
			return 2;
		default:
			return 1;
		}
	}

	public boolean checkShipContact(Ship ship){
		for(SpaceInvader invader : invaders){
			if(invader.contact(ship)){
				return true;
			}
		}
		return false;
	}
	
	public int checkLaserContact(Laser laser) {
		Iterator<SpaceInvader> invIt = invaders.iterator();
		if (!laser.aLive)
			return 0;
		while (invIt.hasNext()) {
			SpaceInvader invader = invIt.next();
			if (invader.contact(laser)) {
				invIt.remove();
				laser.setaLive(false);
				return invader.type * 10;
			}
		}
		return 0;
	}

	public List<Laser> getLasers() {
		return lasers;
	}

	public List<SpaceInvader> getInvaders() {
		return invaders;
	}
}
