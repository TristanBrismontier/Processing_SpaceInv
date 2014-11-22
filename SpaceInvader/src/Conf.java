import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Conf {
	PApplet p;
	boolean Ri, Le, Ti;
	int lives;
	int score;
	PImage filtre;
	PFont fontA;

	Conf(PApplet p) {
		this.p = p;
		Ri = false;
		Le = false;
		Ti = false;
		lives = 3;
		score = 0;
		filtre = p.loadImage("filtrejeu.tga");
		fontA = p.loadFont("CourierNew36.vlw");
	}
}
