package pathfinder.solver;

import java.util.List;
import pathfinder.domain.Maze;
import pathfinder.domain.path.Direction;

public interface PathFinder {

  List<Direction> findPath(Maze maze);
}
