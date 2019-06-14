package pathfinder.domain;

public enum Element {
    OPEN, BLOCKED, START, TARGET;

    public boolean isOpen() {
        return this != BLOCKED && this != START;
    }
}
