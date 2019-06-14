package pathfinder.solver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import pathfinder.domain.Cell;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;
import pathfinder.solver.path.Direction;

public class DfsPathFinder implements PathFinder {

  private boolean found;

  @Override
  public List<Direction> findPath(Maze maze) {
    HashSet<Position> visitedPositions = new HashSet<>();
    HashMap<Position, Position> pathTo = new HashMap<>();
    found = false;
    findPath(maze, maze.getStart(), visitedPositions, pathTo);
    return found ? tracePath(maze, pathTo) : List.of();
  }

  private void findPath(Maze maze, Cell current, HashSet<Position> visitedCells,
      HashMap<Position, Position> pathTo) {
    if (!found) {
      if (current == maze.getTarget()) {
        found = true;
      } else {
        visitedCells.add(current.getPosition());
        List<Cell> neighbours = maze.reachableNeighboursFor(current);
        for (Cell n : neighbours) {
          if (!visitedCells.contains(n.getPosition())) {
            pathTo.put(n.getPosition(), current.getPosition());
            findPath(maze, n, visitedCells, pathTo);
          }
        }
      }
    }
  }

  private List<Direction> tracePath(Maze maze, HashMap<Position, Position> pathTo) {
    LinkedList<Position> path = new LinkedList<>();
    for (Position cur = maze.getTarget().getPosition(); cur != maze.getStart().getPosition();
        cur = pathTo.get(cur)) {
      path.push(cur);
    }
    path.push(maze.getStart().getPosition());
    return mapToDirections(path);
  }

  private List<Direction> mapToDirections(LinkedList<Position> path) {
    LinkedList<Direction> directions = new LinkedList<>();
    for (int i = 1; i < path.size(); i++) {
      directions.add(Direction.describeDirection(path.get(i - 1), path.get(i)));
    }
    return directions;
  }
}
