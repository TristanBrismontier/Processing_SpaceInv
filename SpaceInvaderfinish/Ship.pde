  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/

class Ship extends Entity {

   float minLimit;
   float maxLimit;
    float shipVelocity = 3;
  
  /**
   * Create new Ship 
   * 
   */
  Ship(float x_, float y_) {
    super(new PVector(x_, y_));
    this.minLimit=width / 15;
    this.maxLimit=14 * width / 15;
  }

  /**
   * Create new Ship 
   * With define Y value
   */
  Ship() {
    super(new PVector(width / 2, 9 * height / 10));
    super.setHitbox(new PVector(-15, -10), new PVector(30, 14));
    this.minLimit=width / 15;
    this.maxLimit=14 * width / 15;
  }


  public void display() {
     float x = location.x;
     float y = location.y;
    noStroke();
    fill(0, 255, 0);
    rectMode(CENTER);
    rect(x, y, 30, 14);
    rect(x, y - 10, 6, 6);
    rect(x, y - 14, 2, 2);
    fill(0);
    rect(x - 14, y - 6, 2, 2);
    rect(x + 14, y - 6, 2, 2);
    
  }

  /**
   * Add delta to X
   * @param delta
   */
  void move(float delta) {
    location.x = constrain(location.x + delta, minLimit,maxLimit);
  }
  
  void moveLeft(){
    move(-shipVelocity);
  }
  
  void moveRight(){
    move(shipVelocity);
  }
  
  /**
   * Set X position
   * @param newPosition
   */
  void setPosition(float newPosition){
    location.x = constrain(newPosition, minLimit,maxLimit);
  }
}
