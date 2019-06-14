package pathfinder.solver.path;

import pathfinder.domain.Position;

public enum Direction {
  UP('u'),
  DOWN('d'),
  LEFT('l'),
  RIGHT('r');

  private final Character label;

  Direction(Character label) {
    this.label = label;
  }

  public final Character getLabel() {
    return label;
  }

  public static Direction describeDirection(Position from, Position to) {
    int dx = from.getRow() - to.getRow();
    int dy = from.getColumn() - to.getColumn();
    if (dx == 0 && dy == 1) {
      return Direction.LEFT;
    }
    if (dx == 1 && dy == 0) {
      return Direction.UP;
    }
    if (dx == 0 && dy == -1) {
      return Direction.RIGHT;
    }
    if (dx == -1 && dy == 0) {
      return Direction.DOWN;
    }
    throw new RuntimeException("Invalid direction");
  }
}
