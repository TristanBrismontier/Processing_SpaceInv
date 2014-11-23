  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/
  
class Laser extends Entity {

  float speedy;
  int type;

  Laser(float x_, float y_) {
    super(new PVector(x_, y_));
    super.setHitbox(new PVector(-3, -15), new PVector(8, 15));
    speedy = -3;
    type = 2;
  }

  Laser(float x) {
    super( new PVector(x, 9 * height / 10));
    super.setHitbox(new PVector(-1, -10), new PVector(2, 10));
    speedy = 4f;
    type = 1;
  }

 
   void display() {
    if (!aLive)
      return;
    stroke(255);
    if (type == 1) {
      strokeWeight(2);
      line(location.x, location.y, location.x, location.y - 10);
    } else {
      strokeWeight(2);
      line(location.x + 3, location.y, location.x - 3, location.y - 3);
      line(location.x - 3, location.y - 3, location.x + 3,location.y - 6);
      line(location.x + 3, location.y - 6, location.x - 3,location.y - 9);
      line(location.x - 3, location.y - 9, location.x + 3,location.y - 12);
      line(location.x + 3, location.y - 12, location.x - 3,location.y - 15);
    }
    
  }

  void update() {
    location.y = location.y - speedy;
    if (location.y < 0 || location.y > height + 15) {
      aLive = false;
    }
  }
}
