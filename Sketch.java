import processing.core.PApplet;
import processing.core.PImage;



public class Sketch extends PApplet {
	
  // Global Variables
  PImage earthBackground;
  PImage moonImage; 

  float fltEarthBackgroundX = 200;
  float fltEarthBackgroundY = 200;

  float fltMoonX = 50;
  float fltMoonY = 50;
  float fltMoonSpeedX = 10000;
  float fltMoonSpeedY = 10000;
  float fltMoonRadius = 75;
  float fltRadius = 160;
  float fltCurrentAngle;

  float fltAsteroidX = 20;
  float fltAsteroidY = 220;
  float fltAsteroidSpeedX = 10;
  float fltAsteroidSpeedY = 10;
  float fltAsteroidRadius = 30;
  
  public void settings() {
	  // Size of the canvas
    size(400, 400);
  }

 
  public void setup() {
 
    earthBackground = loadImage("pic2.png");
    earthBackground.resize(earthBackground.width*2, earthBackground.height*2);
    moonImage = loadImage("yellow-foam-ball-with-only-two-eyes-NO-expression-emoji-1024x576.png");
    moonImage.resize(75, 75);
  }

  public void draw() {
    // Improted images drawn to the screen with global variables.
	  image(earthBackground, fltEarthBackgroundX, fltEarthBackgroundY);
    
    image(moonImage, fltMoonX + fltEarthBackgroundX, fltMoonY + fltEarthBackgroundY);
    
    // Circle asteroid with craters
    noStroke();
    fill(128, 128, 128);
    ellipse(fltAsteroidX, fltAsteroidY, fltAsteroidRadius, fltAsteroidRadius);

    // Basic edge detection and movement of the asteroid.
    fltAsteroidX = fltAsteroidX + fltAsteroidSpeedX;
    fltAsteroidY = fltAsteroidY + fltAsteroidSpeedY;
    
    if(fltAsteroidX < 0 || fltAsteroidX > width) {
      fltAsteroidSpeedX = fltAsteroidSpeedX * -1;
    }

    if(fltAsteroidY < 0 || fltAsteroidY > height) {
      fltAsteroidSpeedY = fltAsteroidSpeedY * -1;
    }

    // Movement of the moon
    fltCurrentAngle += 1;
    
    // Movement of the moon in a circular motion based off the given radius.
    fltMoonX = (int) (fltRadius * Math.sin(fltCurrentAngle * Math.PI / 180));
    fltMoonY = (int) (fltRadius * Math.cos(fltCurrentAngle * Math.PI / 360));
   

  }

}