  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/

class SpaceInvader extends Entity {
  int type;

  SpaceInvader(int X_, int Y_, int _type) {
    super(new PVector(X_, Y_));
    super.setHitbox(new PVector(-12, -8), new PVector(24, 16));
    type = _type;
  }

  public void display(boolean flag) {
    float spX = location.x;
    float spY = location.y;
    if (type == 1) {
      noStroke();
      fill(255);
      rectMode(CORNER);
      rect(-4 + spX, -8 + spY, 8, 2);
      rect(-10 + spX, -6 + spY, 20, 2);
      rect(-12 + spX, -4 + spY, 24, 2);
      rect(-12 + spX, -2 + spY, 6, 2);
      rect(-2 + spX, -2 + spY, 4, 2);
      rect(6 + spX, -2 + spY, 6, 2);
      rect(-12 + spX, spY, 24, 2);
      rect(2 + spX, 2 + spY, 4, 2);
      rect(-6 + spX, 2 + spY, 4, 2);
      rect(-2 + spX, 4 + spY, 4, 2);

      if (flag == false) {
        rect(-8 + spX, 4 + spY, 4, 2);
        rect(4 + spX, 4 + spY, 4, 2);
        rect(-12 + spX, 6 + spY, 4, 2);
        rect(8 + spX, 6 + spY, 4, 2);
      } else {
        rect(-10 + spX, 4 + spY, 4, 2);
        rect(6 + spX, 4 + spY, 4, 2);
        rect(-8 + spX, 6 + spY, 4, 2);
        rect(4 + spX, 6 + spY, 4, 2);
      }
    }
    if (type == 2) {
      noStroke();
      fill(255);
      rectMode(CORNER);
      rect(-7 + spX, -8 + spY, 2, 2);
      rect(5 + spX, -8 + spY, 2, 2);
      rect(-5 + spX, -6 + spY, 2, 2);
      rect(3 + spX, -6 + spY, 2, 2);
      rect(-7 + spX, -4 + spY, 14, 2);
      rect(-7 + spX, -4 + spY, 2, 10);
      rect(5 + spX, -4 + spY, 2, 10);
      rect(-7 + spX, spY, 14, 4);
      rect(-3 + spX, -2 + spY, 6, 2);
      rect(-9 + spX, -2 + spY, 2, 4);
      rect(7 + spX, -2 + spY, 2, 4);
      if (flag == false) {
        rect(-11 + spX, spY, 2, 6);
        rect(9 + spX, spY, 2, 6);
        rect(.5f * 2 + spX, 6 + spY, 4, 2);
        rect(-5 + spX, 6 + spY, 4, 2);
      } else {
        rect(-11 + spX, -6 + spY, 2, 6);
        rect(9 + spX, -6 + spY, 2, 6);
        rect(7 + spX, 6 + spY, 2, 2);
        rect(-9 + spX, 6 + spY, 2, 2);
      }
    }
    if (type == 3) {
      noStroke();
      fill(255);
      rectMode(CORNER);
      rect(-2 + spX, spY - 8 , 4, 2);
      rect(-4 + spX, spY - 6, 8, 2);
      rect(-6 + spX, spY - 4, 12, 2);
      rect(-8 + spX, spY - 2, 4, 2);
      rect(-2 + spX, spY - 2, 4, 2);
      rect(4 + spX, spY - 2 , 4, 2);
      rect(-8 + spX, spY, 16, 2);
      rect(-4 + spX, 2 + spY, 2, 2);
      rect(2 + spX, 2 + spY, 2, 2);
      rect(-6 + spX, 4 + spY, 2, 2);
      rect(4 + spX, 4 + spY, 2, 2);
      rect(-4 + spX, 6 + spY, 2, 2);
      rect(2 + spX, 6 + spY, 2, 2);
      rect(-4 + spX, 6 + spY, 2, 2);
      rect(2 + spX, 6 + spY, 2, 2);

      if (flag == false) {
        rect(-8 + spX, 6 + spY, 2, 2);
        rect(6 + spX, 6 + spY, 2, 2);
        rect(-2 + spX, 4 + spY, 4, 2);
      }

    }
    super.display();
  }

  void moveY(float yDelta){
    location.y += yDelta;
  }
  
  boolean moveX(float xDelta) {
    location.x += xDelta;
    if (location.x > 14 * width / 15) {
      return true;
    } else {
      return location.x < width / 15;
    }
  }

}


