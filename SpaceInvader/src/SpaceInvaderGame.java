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
	List<Sheild> sheilds;
	Laser laser;

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
		initializeSheild();
		conf.score = 0;
		conf.vie = 3;
	}

	public void draw() {
		displayScore();
		if (conf.game != true) {
			gameOver();
			return;
		}
		laser.display();
		ship.display();
		fleet.display();
		sheilds.forEach(s -> s.display());

		fleet.update();
		laser.update();
		updateShip();

		conf.score += fleet.checkLaserContact(laser);
		sheilds.forEach(s -> s.contact(laser));
		
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
		// textFont(conf.fontA, 15);
		// textAlign(LEFT);
		// text("Score: ",width/20,height/15);
		// text(conf.score,width/20+60,height/15);
		System.out.println(conf.score);
		strokeWeight(2);
		stroke(0, 255, 0);
		line(0, 9 * height / 10 + 20, width, 9 * height / 10 + 20);
	}

	/*** It's Game Over ***/

	void gameOver() {
		textFont(conf.fontA, 35);
		textAlign(CENTER);
		text("GAME OVER", width / 2, height / 2);
		if (keyPressed) {
			initGame();
		}
	}
}
