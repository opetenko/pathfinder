package pathfinder.domain;

public class Cell {

  private final int x;
  private final int y;
  private final Element element;

  public Cell(int x, int y, Element element) {
    this.x = x;
    this.y = y;
    this.element = element;
  }
}
