package pathfinder.solver;

import static pathfinder.solver.path.PathConstruction.tracePath;

import java.util.HashMap;
import java.util.HashSet;
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
}
