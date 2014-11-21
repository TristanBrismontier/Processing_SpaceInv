import java.util.List;

import processing.core.PApplet;


public class Fleet {

	static final int rows = 5;
	static final int cols = 10;
	int speedUpdate = 40;
	int velocityX = 5;
	int velocityY = 1;
	
	List<SpaceInvader> invaders;
	PApplet p;
	
	
	public Fleet(PApplet p) {
		this.p = p;
		
	}
	
	
	void createNewInvaders(int i,int j)
	{
////	  spaceInv[i][j].location.x=conf.deltaX+35*i;
////	  spaceInv[i][j].location.y=conf.deltaY+30*j;
//	  spaceInv[i][j].existe=true;
//	  conf.sense=5;
//	  conf.fcount=40;
	}

}
