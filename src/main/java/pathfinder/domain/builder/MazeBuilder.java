package pathfinder.domain.builder;

import java.util.List;
import pathfinder.domain.Cell;
import pathfinder.domain.Maze;

public class MazeBuilder {

  private List<Cell> grid;
  private Cell start;
  private Cell target;
  private int rows;
  private int cols;


  public MazeBuilder withGrid(List<Cell> grid) {
    this.grid = grid;
    return this;
  }

  public MazeBuilder withStart(Cell start) {
    this.start = start;
    return this;
  }

  public MazeBuilder withTarget(Cell target) {
    this.target = target;
    return this;
  }

  public MazeBuilder withDimensions(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    return this;
  }

  public Maze build() {
    return new Maze(grid, start, target, rows, cols);
  }
}
