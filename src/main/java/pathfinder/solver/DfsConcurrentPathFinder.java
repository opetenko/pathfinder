package pathfinder.solver;

import static pathfinder.solver.path.PathConstruction.tracePath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import pathfinder.domain.Cell;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;
import pathfinder.solver.path.Direction;

public class DfsConcurrentPathFinder implements PathFinder {

  private final AtomicBoolean found = new AtomicBoolean(false);
  private final AtomicReference<HashMap<Position, Position>> path = new AtomicReference<>();

  @Override
  public List<Direction> findPath(Maze maze) {
    found.set(false);
    Set<Position> visitedPositions = ConcurrentHashMap.newKeySet();
    DfsTask root = new DfsTask(maze, new HashMap<>(), visitedPositions, maze.getStart());
    root.fork();
    root.join();
    return found.get() ? tracePath(maze, path.get()) : List.of();
  }

  private class DfsTask extends RecursiveAction {

    private final Maze maze;
    private final HashMap<Position, Position> pathTo;
    private final Set<Position> visitedPositions;
    private final Cell current;

    public DfsTask(Maze maze,
        HashMap<Position, Position> pathTo, Set<Position> visitedPositions,
        Cell current) {
      this.maze = maze;
      this.pathTo = pathTo;
      this.visitedPositions = visitedPositions;
      this.current = current;
    }

    @Override
    protected void compute() {
      if (!found.get()) {
        if (current == maze.getTarget()) {
          found.set(true);
          path.set(pathTo);
        } else {
          visitedPositions.add(current.getPosition());
          List<Cell> neighbours = maze.reachableNeighboursFor(current);
          List<DfsTask> childTasks = new ArrayList<>();
          for (Cell n : neighbours) {
            if (!visitedPositions.contains(n.getPosition())) {
              pathTo.put(n.getPosition(), current.getPosition());
              DfsTask child = new DfsTask(maze, new HashMap<>(pathTo), visitedPositions, n);
              child.fork();
              childTasks.add(child);
            }
          }
          childTasks.forEach(DfsTask::join);
        }
      }
    }
  }
}
