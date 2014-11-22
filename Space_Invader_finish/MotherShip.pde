  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/

class MotherShip extends Entity {
  float speedx;

  MotherShip() {
    super(new PVector(width / 2, 65));
    super.setHitbox(new PVector(-16, -6), new PVector(32, 12));
    aLive = false;
    speedx = 1;
  }

  @Override
  public void display() {
    if (aLive == true) {
      noStroke();
      fill(255, 10, 10);
      rectMode(CORNER);
      rect(-6 + location.x, -6 + location.y, 12, 2);
      rect(-10 + location.x, -4 + location.y, 20, 2);
      rect(-12 + location.x, -2 + location.y, 24, 2);
      rect(-14 + location.x, 0 + location.y, 4, 2);
      rect(-8 + location.x, 0 + location.y, 4, 2);
      rect(-2 + location.x, 0 + location.y, 4, 2);
      rect(4 + location.x, 0 + location.y, 4, 2);
      rect(10 + location.x, 0 + location.y, 4, 2);
      rect(-16 + location.x, 2 + location.y, 32, 2);
      rect(-12 + location.x, 4 + location.y, 6, 2);
      rect(-2 + location.x, 4 + location.y, 4, 2);
      rect(6 + location.x, 4 + location.y, 6, 2);
      rect(-10 + location.x, 6 + location.y, 2, 2);
      rect(8 + location.x, 6 + location.y, 2, 2);
    }
    super.display();
  }

  void launchMotherShip(boolean k) {
    if (k) {
      location.x = -14;
      speedx = random(0.8f, 2);
    } else {
      location.x = width + 14;
      speedx = -random(0.8f, 2);
    }
    aLive = true;
  }

  void update() {
    if (location.x + 16 > 0 && location.x - 16 < width) {
      location.x = location.x + speedx;
    } else {
      aLive = false;
    }
  }

  int checkContact(Laser laser) {
    if (contact(laser)) {
      laser.setaLive(false);
      setaLive(false);
      return 100;
    }
    return 0;
  }
}
