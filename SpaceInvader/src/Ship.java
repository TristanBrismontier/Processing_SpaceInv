import processing.core.PApplet;
import processing.core.PVector;

public class Ship extends Entity {

	final float minLimit;
	final float maxLimit;
	static final float shipVelocity = 3;
	
	/**
	 * Create new Ship 
	 * 
	 */
	Ship(float x_, float y_, PApplet p) {
		super(p, new PVector(x_, y_));
		this.minLimit=p.width / 15;
		this.maxLimit=14 * p.width / 15;
	}

	/**
	 * Create new Ship 
	 * With define Y value
	 */
	Ship(PApplet p) {
		super(p, new PVector(p.width / 2, 9 * p.height / 10));
		super.setHitbox(new PVector(-15, -10), new PVector(30, 14));
		this.minLimit=p.width / 15;
		this.maxLimit=14 * p.width / 15;
	}

	@Override
	public void display() {
		final float x = location.x;
		final float y = location.y;
		p.noStroke();
		p.fill(0, 255, 0);
		p.rectMode(p.CENTER);
		p.rect(x, y, 30, 14);
		p.rect(x, y - 10, 6, 6);
		p.rect(x, y - 14, 2, 2);
		p.fill(0);
		p.rect(x - 14, y - 6, 2, 2);
		p.rect(x + 14, y - 6, 2, 2);
		super.display();
	}

	/**
	 * Add delta to X
	 * @param delta
	 */
	void move(float delta) {
		location.x = p.constrain(location.x + delta, minLimit,maxLimit);
	}
	
	void moveLeft(){
		move(-shipVelocity);
	}
	
	void moveRight(){
		move(shipVelocity);
	}
	
	/**
	 * Set X position
	 * @param newPosition
	 */
	void setPosition(float newPosition){
		location.x = p.constrain(newPosition, minLimit,maxLimit);
	}
}
