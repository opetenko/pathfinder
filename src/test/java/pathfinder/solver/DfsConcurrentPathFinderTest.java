package pathfinder.solver;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pathfinder.io.MazeReader;
import pathfinder.solver.path.Direction;

public class DfsConcurrentPathFinderTest {

  @Test
  public void generatePathVerification() throws UnsupportedEncodingException {
    var mazeString = "...\nS..\n.#X\n...\n\n";
    var mazeInputStream = new ByteArrayInputStream(mazeString.getBytes("UTF-8"));
    var stdFindPathReader = MazeReader.fromInputStream(mazeInputStream);
    var maze = stdFindPathReader.readMaze();

    PathFinder pathFinder = new DfsConcurrentPathFinder();

    List<Direction> path = pathFinder.findPath(maze);
    Assert.assertNotNull(path);
    Assert.assertFalse(path.isEmpty());
  }
}