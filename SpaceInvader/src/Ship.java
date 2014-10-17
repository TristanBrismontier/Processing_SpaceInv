import processing.core.PApplet;
import processing.core.PVector;


public class Ship extends Entity {
	  int taille;

	Ship(float x_, float y_, PApplet p)
	  {
		super(p, new PVector(x_, y_));
	    taille=2;
	  }
	  
	  Ship(PApplet p)
	  {
		  super(p, new PVector(p.width/2, 9*p.height/10));
		  super.setHitbox(new PVector(-15, -10),new PVector(30,14));
	    taille=2;
	  }

	  
	  @Override
	   public void display()
	  {
		  p.noStroke();
		  p.fill(0,255,0);
		  p.rectMode(p.CENTER);
		  p.rect(location.x,location.y,15*taille,7*taille); 
		  p.rect(location.x,location.y-5*taille,3*taille,3*taille);
		  p.rect(location.x,location.y-7*taille,taille,taille);
		  p.fill(0);
		  p.rect(location.x-7*taille,location.y-3*taille,taille,taille);
		  p.rect(location.x+7*taille,location.y-3*taille,taille,taille);
		  super.display();
	  }
	  
	  
	  boolean contact(float x_, float y_)
	  {
	    return x_ >location.x-7*taille && x_ < location.x+7*taille && y_ > location.y-15*taille && y_<location.y+taille; 
	  }

	  void move(float sens)
	  {
	    float xt =location.x+sens;

	    if( !(xt > 14*p.width/15) )
	    {  
	      if( !(xt< p.width/15) )
	      {
	        location.x = location.x +sens;
	      }
	    }
	  }

}
