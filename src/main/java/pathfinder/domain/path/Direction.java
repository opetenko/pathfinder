package pathfinder.domain.path;

public enum Direction {
  UP('u'),
  DOWN('d'),
  LEFT('l'),
  RIGHT('r');

  private Character label;

  Direction(Character label) {
    this.label = label;
  }

  public Character getLabel() {
    return label;
  }
}
