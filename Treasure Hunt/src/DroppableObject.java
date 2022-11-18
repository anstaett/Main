
public class DroppableObject extends DraggableObject {

  private InteractiveObject target;

  public DroppableObject(String name, int x, int y, String message, InteractiveObject target,
      InteractiveObject nextClue) {
    super(name, x, y, message);
    this.target = target;
    setNextClue​(nextClue);
  }
  
  public boolean isOver(InteractiveObject other) {
    int otherX = other.getX();
    int otherY = other.getY();
    int otherOtherX = otherX + other.image.width;
    int otherOtherY = otherY + other.image.height;
    if (this.getX() > otherOtherX || this.getX() + this.image.width < otherX || this.getY() > otherOtherY || this.getY() + this.image.width < otherY) {
      return false;
    }
    return true;
  }
  
  public void mouseReleased() {
    stopDragging();
    if(isOver(target)) {
      activateNextClue();
      deactivate();
      target.deactivate();
      System.out.println(message());
    }
  }
}
