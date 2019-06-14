package pathfinder.solver;

import pathfinder.domain.Maze;
import pathfinder.solver.path.Direction;

import java.util.List;

public interface PathFinder {

    List<Direction> findPath(Maze maze);
}
