  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/
 class Fleet {
  int rows = 5;
  int cols = 10;
  int maxInvadersLazer = 3;
  boolean positionFlag;
  boolean boundaryContact = false;
  int speedUpdate = 40;
  float velocityX = 8;
  int velocityY = 8;
  int deltaX;
  int deltaY;

  ArrayList<SpaceInvader> invaders;
  ArrayList<Laser> lasers;

   Fleet() {
    deltaX = width / 10 + 35;
    deltaY = height / 10 + 70;
    invaders = new ArrayList<SpaceInvader>();
    lasers = new ArrayList<Laser>();
    for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        invaders.add(createNewInvaders(i, j));
      }
    }
  }

  SpaceInvader createNewInvaders(int i, int j) {
    return new SpaceInvader(deltaX + (35 * i), deltaY + (30 * j),
        computeTypeFromRow(j));
  }

  void update() {
    updateLasers();
    if (frameCount % speedUpdate != 0)
      return;
    shotLaser();
    positionFlag = !positionFlag;
    if (boundaryContact) {
      boundaryContact = false;
      for (SpaceInvader spaceInvader : invaders) {
        spaceInvader.moveY(velocityY);
      }
      
      return;
    }
    for (SpaceInvader spaceInvader : invaders) {
      if (spaceInvader.moveX(velocityX)) {
        boundaryContact = true;
      }
    }

    if (boundaryContact)
      maneuveFleet();
  }

   void updateLasers() {
    ArrayList<Laser> laserToRemove = new ArrayList<Laser>();
    for(Laser l : lasers){
      l.update();
      if (!l.aLive) {
        laserToRemove.add(l);
      }
    }
    // Remove died laser
    for(Laser l : laserToRemove){
      lasers.remove(l);
    }
  }

   void shotLaser() {
    if (lasers.size() >= maxInvadersLazer)
      return;
    if (random(100) <= 75)
      return;

    int randomInvaderIndex = (int) random(invaders.size()) - 1;
    randomInvaderIndex = constrain(randomInvaderIndex, 0,
        invaders.size() - 1);
    SpaceInvader shootingInvader = invaders.get(randomInvaderIndex);

    lasers.add(new Laser(shootingInvader.location.x,
        shootingInvader.location.y));
  }

   void maneuveFleet() {
    speedUpdate -= 3;
    speedUpdate = constrain(speedUpdate, 6, 60);
    if (velocityX > 0) {
      velocityX = velocityX * -1 - 0.3f;
    } else {
      velocityX = velocityX * -1 + 0.3f;
    }
    velocityX = constrain(velocityX, -14, 14);
  }

  void display() {
    for (SpaceInvader spaceInvader : invaders) {
        spaceInvader.display(positionFlag);
     }
    for (Laser l : lasers){
      l.display();
    }
  }

   int computeTypeFromRow(int j) {
    switch (j) {
    case 0:
      return 3;
    case 1:
    case 2:
      return 2;
    default:
      return 1;
    }
  }

  boolean checkShipContact(Ship ship){
    for(SpaceInvader invader : invaders){
      if(invader.contact(ship)){
        return true;
      }
    }
    return false;
  }

   int checkLaserContact(Laser laser) {
    if (!laser.aLive)
      return 0;
      
    int score = 0;
  
    ArrayList<SpaceInvader> invaderToRemove = new ArrayList<SpaceInvader>();
    for(SpaceInvader i : invaders){
      if(i.contact(laser)){
        invaderToRemove.add(i);
        laser.setaLive(false);
        score = i.type * 10;
      }      
    }
    // Remove died laser
    for(SpaceInvader i : invaderToRemove){
      invaders.remove(i);
    }
    return score;
  }

   boolean everyInvadersAreDead(){
    return invaders.isEmpty();
  }
  
  
   ArrayList<Laser> getLasers() {
    return lasers;
  }

   ArrayList<SpaceInvader> getInvaders() {
    return invaders;
  }
}
