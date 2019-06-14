package pathfinder;

import java.util.stream.Collectors;
import pathfinder.io.FindPathInputReaderStdIn;
import pathfinder.solver.DfsPathFinder;
import pathfinder.solver.path.Direction;

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
