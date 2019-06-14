package pathfinder.solver;

import pathfinder.domain.Cell;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;
import pathfinder.solver.path.Direction;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DfsPathFinder implements PathFinder {

    @Override
    public List<Direction> findPath(Maze maze) {
        HashSet<Position> visitedCells = new HashSet<>();
        LinkedList<Direction> path = new LinkedList<>();
        findPath(maze, maze.getStart(), visitedCells, path);
        return path;
    }

    private void findPath(Maze maze, Cell current, HashSet<Position> visitedCells, LinkedList<Direction> path) {

    }
}
