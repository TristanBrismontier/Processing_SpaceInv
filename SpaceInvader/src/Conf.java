import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Conf {

	PApplet p;
	boolean flag;
	boolean game;
	boolean fpY;
	boolean Ri, Le, Ti;
	boolean senss;
	boolean jeu;
	boolean shipIsHit;
	boolean shipIsHitLaser;

	float sense;

	int deltaX;
	int deltaY;
	int vie;
	int score;
	int fcount;
	
	PImage filtre;
	PFont fontA;

	Conf(PApplet p) {
		this.p = p;
		
		deltaX = p.width / 10 + 35;
		deltaY = p.height / 10 + 50;
		flag = true;
		fpY = false;
		game = true;
		Ri = false;
		Le = false;
		Ti = false;
		senss = false;
		jeu = false;
		shipIsHit = false;
		shipIsHitLaser = false;
		vie = 3;
		sense = 5;
		fcount = 30;
		score = 0;
//		filtre = p.loadImage("filtrejeu.tga");
//		fontA = p.loadFont("CourierNew36.vlw");
	}

}
