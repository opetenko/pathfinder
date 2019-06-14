package pathfinder.domain;

import java.util.List;

public class Cell {

    private final Position position;
    private final Element element;
    private final List<Position> neighbours;

    public Cell(Position position, Element element, List<Position> neighbours) {
        this.position = position;
        this.element = element;
        this.neighbours = neighbours;
    }

    public Position getPosition() {
        return position;
    }

    public Element getElement() {
        return element;
    }

    public List<Position> getNeighbours() {
        return neighbours;
    }

    public boolean isOpen(){
        return element.isOpen();
    }

    public boolean isTarget() {
        return element.isTarget();
    }
}
