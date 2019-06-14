package pathfinder.solver;

import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pathfinder.io.MazeReader;
import pathfinder.solver.path.Direction;

public class DfsPathFinderTest {


  @Test
  public void generatePathVerification() throws UnsupportedEncodingException {
    var mazeString = "...\nS..\n.#X\n...\n\n";
    var mazeInputStream = new ByteArrayInputStream(mazeString.getBytes("UTF-8"));
    var stdFindPathReader = MazeReader.fromInputStream(mazeInputStream);
    var maze = stdFindPathReader.readMaze();

    PathFinder pathFinder = new DfsPathFinder();

    List<Direction> path = pathFinder.findPath(maze);
    Assert.assertNotNull(path);
    Assert.assertThat(path, is(List
        .of(Direction.UP, Direction.RIGHT, Direction.DOWN, Direction.RIGHT, Direction.DOWN)));
  }
}