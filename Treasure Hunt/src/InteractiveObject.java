import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class InteractiveObject implements Clickable {

  // reference to the PApplet where this object will be drawn
  protected static TreasureHunt processing;
  private final String NAME; // name of this interactive object
  protected PImage image; // reference to the image of this object
  private int x; // x-position of this interactive object in the screen
  private int y; // y-position of this interactive object in the screen
  // Note that the position (x,y) of the interactive object is the position
  // of the upper-left corner of its image (and NOT the center of the image).
  private boolean isActive; // tells whether or not this object is active
  private boolean wasClicked; // tells whether this object was already clicked
  private String message; // message to be displayed when this object is clicked
  private InteractiveObject nextClue; // Object to be activated when this object is
  // clicked the first time, if any

  /**
   * First Constructor class
   *
   * @param name the object name
   * @param x the lateral coordinate of the object
   * @param y the vertical coordinate of the object
   * @param message the message associated with the object
   */
  
  public InteractiveObject(java.lang.String name, int x, int y, java.lang.String message) {
    NAME = name;
    this.x = x;
    this.y = y;
    this.message = message;
    isActive = true;
    wasClicked = false;
    nextClue = null;
    image = processing.loadImage("images" + File.separator + NAME + ".png");

  }
  
  /**
   * First Constructor class
   *
   * @param name the object name
   * @param x the lateral coordinate of the object
   * @param y the vertical coordinate of the object
   * @param message the message associated with the object
   * @param nextClue the nextClue associated with the object
   */

  public InteractiveObject(java.lang.String name, int x, int y, java.lang.String message,
      InteractiveObject nextClue) {
    this(name, x, y, message);
    isActive = true;
    wasClicked = false;
    this.nextClue = nextClue;
    this.nextClue.deactivate();
    image = processing.loadImage("images" + File.separator + NAME + ".png");
  }

  /**
   * sets the processing value active
   * @param processing the processing value of type treasure hunt
   */
  
  public static void setProcessing​(TreasureHunt processing) {
    InteractiveObject.processing = processing;
  }
  
  /**
   * gets the lateral coordinate of the object
   * @param x the lateral coordinate of the object
   */
  
  public int getX() {
    return x;
  }

  /**
   * gets the vertical coordinate of the object
   * @param y the vertical coordinate of the object
   */
  
  public int getY() {
    return y;
  }
  
  /**
   * changes the lateral and vertical coordinates of the object
   * @param dx the change in the lateral position of the object
   * @param dy the change in the vertical position of the object
   */
  
  public void move​(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  /**
   * checks if the 
   * @param dx the change in the lateral position of the object
   * @param dy the change in the vertical position of the object
   */
  
  public boolean hasName​(java.lang.String name) {
    if (name.equals(NAME)&&name!=null) {
      return true;
    }
    return false;
  }

  public boolean isActive() {
    if (isActive == true) {
      return true;
    }
    return false;
  }

  public void activate() {
    isActive = true;
  }

  public void deactivate() {
    // TODO Auto-generated method stub
    isActive = false;
  }

  public java.lang.String message() {
    return message;
  }

  public void setNextClue​(InteractiveObject nextClue) {
    this.nextClue = nextClue;
  }

  protected void activateNextClue() throws NoSuchElementException {
    if (nextClue != null) {
      nextClue.activate();
      processing.add(nextClue);
    } else {
      throw new NoSuchElementException("next clue is null");
    }
  }

  @Override
  public void draw() {
    // TODO Auto-generated method stub
    if (isActive==true)
    this.processing.image(image, x, y);
    

  }

  @Override
  public void mousePressed() {
    // TODO Auto-generated method stub

    if (isMouseOver()) {
      System.out.println(message());
      if(!wasClicked) {
        wasClicked = true;
        try {
          activateNextClue();
        } catch (NoSuchElementException e) {}
        
      } 
    }
  }

  @Override
  public void mouseReleased() {
    // TODO Auto-generated method stub
  }

  @Override
  public boolean isMouseOver() {
    // TODO Auto-generated method stub
    int mouseX = processing.mouseX;
    int mouseY = processing.mouseY;
    int width = image.width;
    int height = image.height;
    if (mouseX > x && mouseX < (x + width) && mouseY > y && mouseY < (y + height)) {
      return true;
    }

    return false;
  }


}
