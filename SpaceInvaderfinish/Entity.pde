  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/
class Entity {
  PVector location;
   PVector hitboxNE;
   PVector hitboxSW;
   boolean aLive;
   boolean debugE;
  

   Entity(PVector location) {
    this.location = new PVector(location.x,location.y);
    this.hitboxNE = new PVector(0, 0);
    this.hitboxSW = new PVector(0, 0);
    this.aLive = true;
  }

   void setHitbox(PVector hitboxNE, PVector hitboxSW) {
    this.hitboxNE = hitboxNE;
    this.hitboxSW = hitboxSW;
  }


   PVector gethitboxNE() {
    PVector hitboxcopNE =  new PVector(hitboxNE.x,hitboxNE.y);
    hitboxcopNE.add(location);
    return hitboxcopNE;
  }

   boolean contact(Entity other) {
    if(!other.aLive||!aLive)return false;
    PVector hitboxcopNE = gethitboxNE();
    PVector otherHitboxcopNE = other.gethitboxNE();

    if (hitboxcopNE.x + hitboxSW.x < otherHitboxcopNE.x)
      return false;
    if (hitboxcopNE.x > otherHitboxcopNE.x + other.hitboxSW.x)
      return false;
    if (hitboxcopNE.y + hitboxSW.y < otherHitboxcopNE.y)
      return false;
    if (hitboxcopNE.y > otherHitboxcopNE.y + other.hitboxSW.y)
      return false;

    return true;
  }
  
   boolean contact(PVector loc, int size) {
    PVector hitboxcopNE = gethitboxNE();
    

    if (hitboxcopNE.x + hitboxSW.x < loc.x)
      return false;
    if (hitboxcopNE.x > loc.x + size)
      return false;
    if (hitboxcopNE.y + hitboxSW.y < loc.y)
      return false;
    if (hitboxcopNE.y > loc.y + size)
      return false;

    return true;
  }

   boolean isaLive() {
    return aLive;
  }

   void setaLive(boolean aLive) {
    this.aLive = aLive;
  }

   void setLocation(PVector location) {
    this.location = location;
  }
}
