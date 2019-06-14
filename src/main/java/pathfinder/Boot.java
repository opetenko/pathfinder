package pathfinder;

import pathfinder.solver.path.Direction;
import pathfinder.io.FindPathInputReaderStdIn;
import pathfinder.solver.DfsPathFinder;

import java.util.stream.Collectors;

public class Boot {

    public static void main(String[] args) {
        var mazeReader = new FindPathInputReaderStdIn();
        var pathFinder = new DfsPathFinder();
        var maze = mazeReader.readMaze();
        var path = pathFinder.findPath(maze);
        var resultPath = path.stream()
                .map(Direction::getLabel)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(resultPath);
    }
}
