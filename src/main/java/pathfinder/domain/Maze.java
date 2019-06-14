package pathfinder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Maze {

  private final List<Cell> grid;
  private final Cell start;
  private final Cell target;
  private final int row;
  private final int col;

  public Maze(List<Cell> grid, Cell start, Cell target, int row, int col) {
    this.grid = Objects.requireNonNull(grid);
    this.start = Objects.requireNonNull(start);
    this.target = Objects.requireNonNull(target);
    this.row = row;
    this.col = col;
  }

  public Cell getStart() {
    return start;
  }

  public Cell getTarget() {
    return target;
  }

  public List<Cell> reachableNeighboursFor(Cell cell) {
    return cell.getNeighbours()
        .stream()
        .map(position -> grid.get(toCellIndex(position)))
        .filter(Cell::isOpen)
        .collect(Collectors.toList());
  }

  private int toCellIndex(Position position) {
    return col * position.getRow() + position.getColumn();
  }
}
