import processing.core.PApplet;

public class ScreenshotButton extends Button {

  public ScreenshotButton(int x, int y) {
    super("Take a Screenshot!", x, y);
    // TODO Auto-generated constructor stub
  }
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      processing.save("screenshot.png");
    }
  }

}
