  /* OpenProcessing Tweak of *@*http://www.openprocessing.org/sketch/6572*@* */
  /*
   * !do not delete the line above, required for linking your tweak if you
   * re-upload
   */

  /** Space Invader Clone **/
  /** Code by Tristan Brismontier **/

  final Conf conf = new Conf();
  Ship ship;
  Fleet fleet;
  Laser laser;
  MotherShip motherShip;
  ArrayList<Ship> livesFeedBck;
  ArrayList<Sheild> sheilds;

  public void setup() {
    size(501, 432);
    frameRate(60);
    initGame();
  }

  public void draw() {
    displayScore();
    if (conf.lives <= 0) {
      gameOver();
      return;
    }
    laser.display();
    ship.display();
    fleet.display();
    motherShip.display();
   
   

    fleet.update();
    laser.update();
    updateShip();
    updateMother();
    
    for (Sheild s : sheilds){
     s.display();
     s.contact(laser);
     s.contact(fleet.getLasers());
     s.contactInvader(fleet.getInvaders());
    }

    conf.score += motherShip.checkContact(laser);
    conf.score += fleet.checkLaserContact(laser);
    for (Laser invaderLaser : fleet.getLasers()) {
      if (ship.contact(invaderLaser)) {
        invaderLaser.setaLive(false);
        conf.lives--;
      }
    }
   // image(conf.filtre, 0, -90);
  }

  /** Ship Actions 
   * You can directly Set X ship by call ship.setPosition(X);
   * This X value will be constraint by borderLimit Ship will stay on screen. 
   * 
   **/

  void updateShip() {
    if (conf.Ri == true) {
      ship.moveRight();
    }
    if (conf.Le == true) {
      ship.moveLeft();
    }
    if (conf.Ti == true) {
      if (!laser.aLive) {
        laser = new Laser(ship.location.x);
      }
    }
  }

  public void keyPressed() {
    if (keyCode == RIGHT) {
      conf.Ri = true;
    }
    if (keyCode == LEFT) {
      conf.Le = true;
    }
    if (key == ' ') {
      conf.Ti = true;
    }
  }

  public void keyReleased() {
    if (keyCode == RIGHT) {
      conf.Ri = false;
    }
    if (keyCode == LEFT) {
      conf.Le = false;
    }
    if (key == ' ') {
      conf.Ti = false;
    }
  }
  
  private void updateMother() {
    if (motherShip.aLive) {
      motherShip.update();
    } else {
      if (frameCount % 60 == 0 && random(100) > 85) {
        motherShip.launchMotherShip(random(100) > 50);
      }
    }
  }

  private void initializeSheild() {
    sheilds = new ArrayList<Sheild>();
    for (int i = 0; i < 4; i++) {
      sheilds.add(new Sheild(i * 125 + 45, 310));
    }
  }

  void initGame() {
    ship = new Ship();
    fleet = new Fleet();
    laser = new Laser( ship.location.x);
    laser.setaLive(false);
    motherShip = new MotherShip();
    initializeSheild();
    conf.score = 0;
    conf.lives = 3;
    livesFeedBck = new ArrayList<Ship>();
    for (int i = 0; i < conf.lives; i++) {
      livesFeedBck.add(new Ship(width - 120 + 40 * i, height / 15));
    }
  }

  void displayScore() {
    background(0);
    fill(255);
   // textFont(conf.fontA, 15);
   // textAlign(LEFT);
   //text("Score: ", width / 20, height / 15);
   // text(conf.score, width / 20 + 60, height / 15);
    strokeWeight(2);
    stroke(0, 255, 0);
    line(0, 9 * height / 10 + 20, width, 9 * height / 10 + 20);
    for (int i = 0; i < conf.lives; i++) {
      Ship ship = livesFeedBck.get(i);
      ship.display();
    }
  }

  void gameOver() {
   // textFont(conf.fontA, 35);
   // textAlign(CENTER);
   // text("GAME OVER", width / 2, height / 2);
    if (mousePressed) {
      initGame();
    }
    //image(conf.filtre, 0, -90);
  }
