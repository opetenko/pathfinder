package pathfinder.domain;

import java.util.List;

public class Maze {

  private final List<Cell> grid;
  private final int dimX;
  private final int dimY;
  private final Cell start;
  private final Cell target;

  public Maze(List<Cell> grid, int dimX, int dimY, Cell start, Cell target) {
    this.grid = grid;
    this.dimX = dimX;
    this.dimY = dimY;
    this.start = start;
    this.target = target;
  }
}
