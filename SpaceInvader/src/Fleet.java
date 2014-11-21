import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;

public class Fleet {

	PApplet p;
	static final int rows = 5;
	static final int cols = 10;
	boolean positionFlag;
	boolean boundaryContact=false;
	int speedUpdate = 40;
	float velocityX = 5;
	int velocityY = 5;
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
				System.out.println(" i : " + i + " j : " +j);
				invaders.add(createNewInvaders(i, j));
			}
		}
	}

	SpaceInvader createNewInvaders(int i, int j) {
		return new SpaceInvader(deltaX + (35 * i), deltaY + (30 * j),
				computeTypeFromRow(j), p);
	}
	
	void update(){
		if(p.frameCount%speedUpdate != 0) return;
		positionFlag = !positionFlag;
		if(boundaryContact){
			boundaryContact = false;
			invaders.forEach(i -> i.moveY(velocityY));
			return;
		}
		for (SpaceInvader spaceInvader : invaders) {
			if(spaceInvader.moveX(velocityX)){
				boundaryContact = true;
			}
		}
		
		if(boundaryContact)maneuveFleet();
	}
	
	private void maneuveFleet() {
		speedUpdate-=3;
		speedUpdate = p.constrain(speedUpdate,9,60);
		    if(velocityX>0)
		    {
		    	velocityX = velocityX * -1 -0.3f ;
		    }
		    else
		    {
		    	velocityX = velocityX * -1 + 0.3f;
		    }
		    velocityX=p.constrain(velocityX,-12,12);
	}

	void display(){
		
		invaders.forEach(i -> i.display(positionFlag));
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
