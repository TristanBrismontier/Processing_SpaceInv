import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class SpaceInvaderGame extends PApplet {
	/* OpenProcessing Tweak of *@*http://www.openprocessing.org/sketch/6572*@* */
	/*
	 * !do not delete the line above, required for linking your tweak if you
	 * re-upload
	 */

	/** Clone de Space Invader **/
	/** Code by Tristan Brismontier **/

	final Conf conf = new Conf(this);
	Ship ship;
	Fleet fleet;
	Laser laser;
	MotherShip motherShip;
	List<Ship> livesFeedBck;
	List<Sheild> sheilds;

	public void setup() {
		size(501, 432);
		frameRate(60);
		initGame();
	}

	void initGame() {
		ship = new Ship(this);
		fleet = new Fleet(this);
		laser = new Laser(this, ship.location.x);
		laser.setaLive(false);
		motherShip = new MotherShip(this);
		initializeSheild();
		conf.score = 0;
		conf.lives = 3;
		livesFeedBck = new ArrayList<Ship>();
		for (int i = 0; i < conf.lives; i++) {
			livesFeedBck.add(new Ship(width - 120 + 40 * i, height / 15, this));
		}
	}

	public void draw() {
		displayScore();
		if (conf.lives <= 0) {
			gameOver();
			return;
		}
		laser.display();
		ship.display();
		fleet.display();
		motherShip.display();
		sheilds.forEach(s -> s.display());

		fleet.update();
		laser.update();
		updateShip();
		updateMother();

		conf.score += motherShip.checkContact(laser);
		conf.score += fleet.checkLaserContact(laser);
		sheilds.forEach(s -> s.contact(laser));
		sheilds.forEach(s -> s.contact(fleet.getLasers()));
		sheilds.forEach(s -> s.contactInvader(fleet.getInvaders()));
		for (Laser invaderLaser : fleet.getLasers()) {
			if (ship.contact(invaderLaser)) {
				invaderLaser.setaLive(false);
				conf.lives--;
			}
		}
		image(conf.filtre, 0, -90);
	}

	private void updateMother() {
		if (motherShip.aLive) {
			motherShip.update();
		} else {
			if (frameCount%60 == 0 && random(100) > 75){
				motherShip.launchMotherShip(random(100) > 50);
			}
		}
	}

	/*** Ship Actions ***/

	void updateShip() {
		if (conf.Ri == true) {
			ship.moveRight();
		}
		if (conf.Le == true) {
			ship.moveLeft();
		}
		if (conf.Ti == true) {
			if (!laser.aLive) {
				laser = new Laser(this, ship.location.x);
			}
		}
	}

	public void keyPressed() {
		if (keyCode == RIGHT) {
			conf.Ri = true;
		}
		if (keyCode == LEFT) {
			conf.Le = true;
		}
		if (key == ' ') {
			conf.Ti = true;
		}
	}

	public void keyReleased() {
		if (keyCode == RIGHT) {
			conf.Ri = false;
		}
		if (keyCode == LEFT) {
			conf.Le = false;
		}
		if (key == ' ') {
			conf.Ti = false;
		}
	}

	private void initializeSheild() {
		sheilds = new ArrayList<Sheild>();
		for (int i = 0; i < 4; i++) {
			sheilds.add(new Sheild(i * 125 + 45, 310, this));
		}
	}

	/***** Affichage du score / Terre / background ******/

	void displayScore() {
		background(0);
		fill(255);
		textFont(conf.fontA, 15);
		textAlign(LEFT);
		text("Score: ", width / 20, height / 15);
		text(conf.score, width / 20 + 60, height / 15);
		strokeWeight(2);
		stroke(0, 255, 0);
		line(0, 9 * height / 10 + 20, width, 9 * height / 10 + 20);
		for (int i = 0; i < conf.lives; i++) {
			Ship ship = livesFeedBck.get(i);
			ship.display();
		}
	}

	/*** It's Game Over ***/

	void gameOver() {
		textFont(conf.fontA, 35);
		textAlign(CENTER);
		text("GAME OVER", width / 2, height / 2);
		if (mousePressed) {
			initGame();
		}
		image(conf.filtre, 0, -90);
	}
}
