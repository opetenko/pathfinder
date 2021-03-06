package pathfinder.solver;

import static pathfinder.solver.path.PathConstruction.tracePath;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import pathfinder.domain.Cell;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;
import pathfinder.solver.path.Direction;

public class BfsPathFinder implements PathFinder {

  private boolean found;

  @Override
  public List<Direction> findPath(Maze maze) {
    HashSet<Position> visitedPositions = new HashSet<>(List.of(maze.getStart().getPosition()));
    HashMap<Position, Position> pathTo = new HashMap<>();
    found = false;
    LinkedList<Cell> queue = new LinkedList<>();
    queue.offer(maze.getStart());
    while (!queue.isEmpty()) {
      Cell current = queue.poll();
      if (current == maze.getTarget()) {
        found = true;
        break;
      } else {
        List<Cell> neighbours = maze.reachableNeighboursFor(current);
        for (Cell n : neighbours) {
          if (!visitedPositions.contains(n.getPosition())) {
            pathTo.put(n.getPosition(), current.getPosition());
            visitedPositions.add(n.getPosition());
            queue.offer(n);
          }
        }
      }
    }
    return found ? tracePath(maze, pathTo) : List.of();
  }
}
