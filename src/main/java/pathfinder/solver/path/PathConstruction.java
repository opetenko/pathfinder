package pathfinder.solver.path;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;

public final class PathConstruction {

  public static List<Direction> tracePath(Maze maze, HashMap<Position, Position> pathTo) {
    LinkedList<Position> path = new LinkedList<>();
    for (Position cur = maze.getTarget().getPosition(); cur != maze.getStart().getPosition();
        cur = pathTo.get(cur)) {
      path.push(cur);
    }
    path.push(maze.getStart().getPosition());
    return mapToDirections(path);
  }

  private static List<Direction> mapToDirections(LinkedList<Position> path) {
    LinkedList<Direction> directions = new LinkedList<>();
    for (int i = 1; i < path.size(); i++) {
      directions.add(Direction.describeDirection(path.get(i - 1), path.get(i)));
    }
    return directions;
  }
}
