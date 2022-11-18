
public class DraggableObject extends InteractiveObject {
  private boolean isDragging;
  private int oldMouseX;
  private int oldMouseY;

  public DraggableObject(String name, int x, int y) {
    super(name, x, y, "Drag Me!");
    isDragging = false;
  }

  public DraggableObject(String name, int x, int y, String message) {
    super(name, x, y, message);
    isDragging = false;
  }


  public void startDragging() {
    isDragging=true;
    oldMouseX = processing.mouseX;
    oldMouseY = processing.mouseY;
  }
  
  public void stopDragging() {
      isDragging=false;
  }

  public boolean isDragging() {
    return isDragging;
  }

  public void mousePressed() {
    if (isMouseOver()) {
    startDragging();
    }
  }
  
  public void mouseReleased() {
    stopDragging();
  }
  
  public void draw() {
    int xChange = processing.mouseX - oldMouseX;
    int yChange = processing.mouseY - oldMouseY;
    if(isDragging() == true) {
      move​(xChange, yChange);
      oldMouseX =processing.mouseX;
      oldMouseY =processing.mouseY;
    }
    super.draw();
  }
  



}
