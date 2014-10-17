import processing.core.PApplet;


public class SpaceInvaderGame extends PApplet {
	/* OpenProcessing Tweak of *@*http://www.openprocessing.org/sketch/6572*@* */
	/* !do not delete the line above, required for linking your tweak if you re-upload */
	/**  Clone de Space Invader **/
	/**  Programmation Tristan Brismontier **/


	int rows = 5;
	int cols = 10;
	SpaceInvader[][] spaceInv = new SpaceInvader[cols][rows];
	Protection[] protec = new Protection[4];
	Laser[] laserEn = new Laser[3];
	Ship[] shipVie = new Ship[3];
	MotherShip motherShip;
	Laser lazer;
	Conf conf;
	Ship ship;

	public void setup()
	{  
	  size(501,432);
	  frameRate(60);
	  conf = new Conf(this);
	  ship = new Ship(this);
	  lazer = new Laser(this);
	  motherShip = new MotherShip(this);

	  for(int i=0;i<shipVie.length;i++)
	  {
	    shipVie[i] = new Ship(width-120+40*i,height/15, this);   
	    laserEn[i] = new Laser(0,0,this);   
	  }
	  for(int i=0;i<protec.length;i++)
	  {
	    protec[i] = new Protection(i*125+45,310,this); 
	  }
	  // Création et placement des space Invader

	  for(int i=0;i<cols;i++)
	  {
	    for(int j=0;j<rows;j++)
	    {
	      if(j==0)
	      {
	        spaceInv[i][j] = new SpaceInvader(conf.deltaX+35*i,conf.deltaY+30*j,3, this); 
	      }  
	      else
	      {  
	        if(j==1 || j==2)
	        {
	          spaceInv[i][j] = new SpaceInvader(conf.deltaX+35*i,conf.deltaY+30*j,2, this);
	        }
	        else
	        {
	          spaceInv[i][j] = new SpaceInvader(conf.deltaX+35*i,conf.deltaY+30*j,1, this);
	        }
	      }
	    }
	  }

	}



	/**************  Commencement *************/



	public void draw()
	{
		
	  displayScore();

	  if(conf.game==true)
	  {
	    initVar();


	    lazer.display();
	    ship.display();
	    lazer.move();

	    actionShip();

	    // Gestion du MotherShip
	    motherShip.display();
	    motherShip.move();
	    if(motherShip.contact(lazer.location.x,lazer.location.y)==false)
	    {
	      conf.score += random(40,250);
	      lazer.tire=false;
	      lazer.location.y=height; 
	    }
	    if(random(100) > 99.7)
	    {

	      if(motherShip.existe == false)
	      {   
	        float k = random(0,2);
	        motherShip.lancement(k);
	      }
	    }
	    // fini avec le Mothership

	    for(int i=0;i<protec.length;i++)
	    {
	      protec[i].display();

	    }


	    if(frameCount % conf.fcount == 0 )
	    {

	      conf.flag = !conf.flag;
	      for(int i=0;i<cols;i++)
	      {

	        for(int j=0;j<rows;j++)
	        {

	          if(spaceInv[i][j].move(conf.sense, conf.fpY) == true)
	          {
	            conf.senss=true; 
	          }

	        }
	      }
	    }

	    for(int i=0;i<cols;i++)
	    {

	      if(i<3)
	      {
	        laserEn[i].move();
	        laserEn[i].display();
	        if(ship.contact(laserEn[i].location.x,laserEn[i].location.y) == true)
	        {
	          conf.shipIsHitLaser=true;
	          laserEn[i] = new Laser(0,0,this);
	        }
	        for(int k=0; k < protec.length;k++)
	        {
	          if(protec[k].contact(laserEn[i].location.x,laserEn[i].location.y)== true)
	          {
	            protec[k].contact(laserEn[i].location.x,laserEn[i].location.y+2);
	            laserEn[i] = new Laser(0,0,this);
	          }
	          if(protec[k].contact(lazer.location.x,lazer.location.y)== true)
	          {
	            lazer.tire=false;
	            lazer.location.y=height;
	          }
	        }
	      }

	      if(i<conf.vie)
	      {
	        shipVie[i].display();
	      }

	      for(int j=0;j<rows;j++)
	      {

	        for(int k=0; k < protec.length;k++)
	        {
	          for(int p =0; p<15;p++)
	          {
	            for(int o=0; o<20;o++)
	            {
	              if(spaceInv[i][j].existe == true)
	              {
	                if(protec[k].protect[p][o]==1)
	                {
	                  if(o*protec[k].taillex+protec[k].location.x >spaceInv[i][j].location.x-4*spaceInv[i][j].taillex && o*protec[k].taillex+protec[k].location.x < spaceInv[i][j].location.x+4*spaceInv[i][j].taillex && p*protec[k].tailley+protec[k].location.y < spaceInv[i][j].location.y+4*spaceInv[i][j].tailley)
	                  {
	                    protec[k].protect[p][o]=0;
	                  } 
	                }
	              }
	            }  
	          }      
	        }



	        if(spaceInv[i][j].contact(lazer.location.x,lazer.location.y)==false)
	        {
	          switch (spaceInv[i][j].type)
	          {
	          case 1: 
	            conf.score += 10; 
	            break;
	          case 2: 
	            conf.score += 20; 
	            break;
	          case 3: 
	            conf.score += 40; 
	            break;
	          }
	          lazer.tire=false;
	          lazer.location.y=height;
	        }

	        if(spaceInv[i][j].existe==true)
	        { 
	          if(random(100) > 99.98)
	          {
	            int k = (int) random(0,3);
	            if(laserEn[k].tire == false)
	            {
	              laserEn[k].lancement(spaceInv[i][j].location.x,spaceInv[i][j].location.y);
	            }
	          }
	          if(ship.contact(spaceInv[i][j].location.x,spaceInv[i][j].location.y)==true ||  spaceInv[i][j].location.y>=9*height/10)
	          {
	            conf.shipIsHit=true;
	          }
	          conf.jeu=true;
	        }

	        spaceInv[i][j].display(conf.flag);

	      }
	    }


	    changeOfDirection();

	    shipIsHit();

	    if(conf.jeu==false || conf.shipIsHit==true)
	    {
	      if(conf.shipIsHit==true)conf.vie-=1;
	      if(conf.vie<0)conf.game=false;
	      for(int i=0;i<cols;i++)
	      {
	        for(int j=0;j<rows;j++)
	        {
	          init(i,j);
	        }
	      }
	    }
	  }
	  else
	  {
	    gameOver();
	  }
	  // Affichage du filtre style allow Arcade 
//	  image(conf.filtre, 0, 0);
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
	  spaceInv[i][j].location.x=conf.deltaX+35*i;
	  spaceInv[i][j].location.y=conf.deltaY+30*j;
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
