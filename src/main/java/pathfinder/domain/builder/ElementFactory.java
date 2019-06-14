package pathfinder.domain.builder;

import pathfinder.domain.Element;

public class ElementFactory {

    public Element build(Character label) {
        switch (label) {
            case '.':
                return Element.OPEN;
            case '#':
                return Element.BLOCKED;
            case 'S':
                return Element.START;
            case 'X':
                return Element.TARGET;
            default:
                throw new RuntimeException("Invalid element value");
        }
    }
}
