import processing.core.PApplet;
import processing.core.PVector;


public class Entity {
	protected PApplet p;
	protected PVector location;
	protected PVector hitboxNE;
	protected PVector hitboxSW;

	public Entity(PApplet p, PVector location) {
		this.p = p;
		this.location = location.get();
		this.hitboxNE = new PVector(0, 0);
		this.hitboxSW = new PVector(0, 0);
	}
	
	public void setHitbox(PVector hitboxNE,PVector hitboxSW){
		
		this.hitboxNE = hitboxNE;
		this.hitboxSW = hitboxSW;
	}
	
	public void display(){
		p.fill(255,0,0,100);
		p.rectMode(p.CORNER);
		p.noStroke();
		 PVector hitboxcopNE = hitboxNE.get();
		hitboxcopNE.add(location);
		
		 
		p.rect(hitboxcopNE.x,hitboxcopNE.y,hitboxSW.x,hitboxSW.y);
		p.ellipse(location.x, location.y, 5, 5);
	}
	
	public PVector gethitboxNE(){
		 PVector hitboxcopNE = hitboxNE.get();
		 hitboxcopNE.add(location);
		 return hitboxcopNE;
	}
	
	public boolean contact(Entity other){
		PVector hitboxcopNE = gethitboxNE();
		PVector otherHitboxcopNE = gethitboxNE();
		
		if (hitboxcopNE.x+hitboxSW.x < otherHitboxcopNE.x) { return false; }
		  if (hitboxcopNE.x > otherHitboxcopNE.x+other.hitboxSW.x) { return false; }
		  if (hitboxcopNE.y+hitboxSW.y < otherHitboxcopNE.y) { return false; }
		  if (hitboxcopNE.y > otherHitboxcopNE.y+other.hitboxSW.y) { return false; }
	
		  return true;    

	}

}
