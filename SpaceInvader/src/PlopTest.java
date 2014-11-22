import processing.core.PApplet;
import processing.core.PVector;


public class PlopTest extends PApplet {
	
	Entity ent1;
	Entity ent2;
	
	public void setup()
	{  
	  size(501,432);
	  ent1 = new Entity(this, new PVector(width/2, height/2));
	  ent1.setHitbox(new PVector(-20, -20), new PVector(40, 40));
	  ent2 = new Entity(this, new PVector(width/2, height/2));
	  ent2.setHitbox(new PVector(-20, -20), new PVector(40, 40));

	}

	public void draw()
	{
		background(0);
		ent1.setLocation(new PVector(mouseX, mouseY));
		ent1.display();
		ent2.display();
		ent1.contact(ent2);
		
	}

}
