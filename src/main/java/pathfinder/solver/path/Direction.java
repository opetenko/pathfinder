package pathfinder.solver.path;

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
}
