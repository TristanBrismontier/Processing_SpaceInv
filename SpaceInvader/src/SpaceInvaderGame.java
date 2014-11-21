import processing.core.PApplet;


public class SpaceInvaderGame extends PApplet {
	/* OpenProcessing Tweak of *@*http://www.openprocessing.org/sketch/6572*@* */
	/* !do not delete the line above, required for linking your tweak if you re-upload */
	/**  Clone de Space Invader **/
	/**  Programmation Tristan Brismontier **/


	int rows = 5;
	int cols = 10;
	Conf conf;

	public void setup()
	{  
	  size(501,432);
	  frameRate(60);
	  conf = new Conf(this);
	}



	/**************  Commencement *************/



	public void draw()
	{
		
	  displayScore();

	  if(conf.game!=true)
	  {
		  gameOver();
		  return;
	  }

	}


	/***  Gestion des Touches ***/


	public void keyPressed()
	{
	  if(keyCode==RIGHT)
	  {
	    conf.Ri=true;
	  }
	  if(keyCode==LEFT)
	  {
	    conf.Le=true;
	  }
	  if(key==' ')
	  {
	    conf.Ti=true;
	  }
	}

	public void keyReleased()
	{
	  if(keyCode==RIGHT)
	  {
	    conf.Ri=false;
	  }
	  if(keyCode==LEFT)
	  {
	    conf.Le=false;
	  }
	  if(key==' ')
	  {
	    conf.Ti=false;
	  }
	}

	/*** Les Actions du ship ***/

	void actionShip()
	{
	  if(conf.Ri==true)
	  {
	    ship.move(3);
	  }
	  if(conf.Le==true)
	  {
	    ship.move(-3);
	  }
	  if(conf.Ti==true)
	  {
	    lazer.lancement(ship.location.x);
	  }
	}


	/***  Initialistaion  de Variable de Draw()  ***/

	void initVar()
	{
	  conf.senss=false;
	  conf.jeu=false;
	  conf.shipIsHit=false;
	  conf.shipIsHitLaser=false;
	}


	/***  Initialisation des Invader  ***/


	void init(int i,int j)
	{
//	  spaceInv[i][j].location.x=conf.deltaX+35*i;
//	  spaceInv[i][j].location.y=conf.deltaY+30*j;
	  spaceInv[i][j].existe=true;
	  conf.sense=5;
	  conf.fcount=40;
	}



	/*****  Affichage du score / Terre  / background  ******/


	void displayScore ()
	{
		background(0);
//	  textFont(conf.fontA, 15);
//	  textAlign(LEFT);
//	  text("Score: ",width/20,height/15);
//	  text(conf.score,width/20+60,height/15);
	  strokeWeight(2);
	  stroke(0,255,0);
	  line(0,9*height/10+20,width,9*height/10+20);
	}


	/*** It's Game Over ***/

	void gameOver()
	{
	  textFont(conf.fontA, 35);
	  textAlign(CENTER);
	  text("GAME OVER",width/2,height/2);
	  if(mousePressed)
	  {
	    for(int i=0;i<protec.length;i++)
	    {
	      protec[i] = new Protection(i*125+45,310,this); 
	    }
	    conf.score=0;
	    conf.vie=3;
	    conf.game=true;
	    for(int i=0;i<cols;i++)
	    {
	      for(int j=0;j<rows;j++)
	      {
	        init(i,j);
	      }
	    }
	  }
	}

	/***  change Of Direction ***/

	void changeOfDirection()
	{
	  if(conf.senss == true)
	  {
	    conf.fcount=conf.fcount-3;
	    conf.fcount = constrain(conf.fcount,9,60);
	    if(conf.sense>0)
	    {
	      conf.sense = conf.sense * -1 -0.3f ;
	    }
	    else
	    {
	      conf.sense = conf.sense * -1 + 0.3f;
	    }
	    conf.sense=constrain(conf.sense,-12,12);

	    conf.fpY=!conf.fpY;    
	  }
	}

	/***  Le Ship is hit ***/

	void shipIsHit()
	{
	  if(conf.shipIsHitLaser==true)
	  {
	    conf.vie-=1;
	    if(conf.vie<0)conf.game=false;
	  }
	}


















}
