
public class RestartGameButton extends Button {
  public RestartGameButton(int x, int y) {
    super("Restart Game", x, y);
    // TODO Auto-generated constructor stub
  }
  @Override
  public void mousePressed() {
    if (isMouseOver()) { 
      ((TreasureHunt)processing).initGame();
    }
  }
}
