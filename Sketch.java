import processing.core.PApplet;
import processing.core.PImage;


/**
* A program that makes an atom thingy.
* @author: L.Lam
*
*/


public class Sketch extends PApplet {
 
  // Global Variables
  PImage earthBackground;
  PImage ElectronImage;


  float fltEarthBackgroundX = 0;
  float fltEarthBackgroundY = 0;


  float[] fltElectronX;
  float[] fltElectronY;
  float[] fltElectronSpeedX;
  float[] fltElectronSpeedY;
  float[] fltElectronRadius;
  float[] fltRadius;
  float[] fltCurrentAngle;


  float fltNeutronX = 800;
  float fltNeutronY = 800;
  float fltNeutronSpeedX = 30;
  float fltNeutronSpeedY = 40;
  float fltNeutronRadius = 50;
 
   /**
  * @param settings sets the size of the window
  * @author L.Lam
  */


  public void settings() {
    size(800, 800);
  }


   /**
  * @param setup loads and resizes images and background
  * @author L.Lam
  */


  public void setup() {


    // Load images and resize them
    earthBackground = loadImage("nucleus.jpg");
    earthBackground.resize(height, width);
    ElectronImage = loadImage("electron.png");
    ElectronImage.resize(35, 35);


    // Initialize arrays for electrons
    int numberOfElectrons = 10;
    fltElectronX = new float[numberOfElectrons];
    fltElectronY = new float[numberOfElectrons];
    fltElectronSpeedX = new float[numberOfElectrons];
    fltElectronSpeedY = new float[numberOfElectrons];
    fltElectronRadius = new float[numberOfElectrons];
    fltRadius = new float[numberOfElectrons];
    fltCurrentAngle = new float[numberOfElectrons];


    // Poperties
    for (int i = 0; i < numberOfElectrons; i++) {
      fltElectronRadius[i] = 50 + i * 30;
      fltRadius[i] = 150 + i * 30;
      fltCurrentAngle[i] = random(360);
      fltElectronSpeedX[i] = random(-2, 2);
      fltElectronSpeedY[i] = random(-2, 2);
    }
  }


   /**
  * @param Draw Draws electrons, neutrons and background images
  * @author L.Lam
  */


  public void draw() {
   
    // Background image
    image(earthBackground, fltEarthBackgroundX, fltEarthBackgroundY);
   
    // Draw Electrons
    for (int i = 0; i < fltElectronX.length; i++) {
      fltCurrentAngle[i] += 1;
      fltElectronX[i] = width / 2 + (int) (fltRadius[i] * Math.sin(fltCurrentAngle[i] * Math.PI / 180));
      fltElectronY[i] = height / 2 + (int) (fltRadius[i] * Math.cos(fltCurrentAngle[i] * Math.PI / 180));
      image(ElectronImage, fltElectronX[i] - ElectronImage.width / 2, fltElectronY[i] - ElectronImage.height / 2);


    }
   
    // Draw the neutron
    noStroke();
    fill(50, 255, 40);
    ellipse(fltNeutronX, fltNeutronY, fltNeutronRadius, fltNeutronRadius);
    fill(255);
    textAlign(CENTER, CENTER);
    textSize(50);
    text("o", fltNeutronX, fltNeutronY);


    // Move the neutron and adds edge detection
    fltNeutronX += fltNeutronSpeedX;
    fltNeutronY += fltNeutronSpeedY;
    if(fltNeutronX < 0 || fltNeutronX > width) {
      fltNeutronSpeedX *= -1;
    }
    if(fltNeutronY < 0 || fltNeutronY > height) {
      fltNeutronSpeedY *= -1;
    }
  }
}



