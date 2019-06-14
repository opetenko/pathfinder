package pathfinder.domain;

import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import pathfinder.domain.builder.MazeBuilder;

public class MazeTest {

  @Test
  public void verifyMazeBuilt() {
    List<Cell> grid = new ArrayList<>();
    Cell start = new Cell(new Position(1, 0), Element.START, List.of());
    Cell target = new Cell(new Position(1, 0), Element.TARGET, List.of());
    Maze maze = new MazeBuilder().withGrid(grid)
        .withStart(start)
        .withTarget(target)
        .build();
    Assert.assertThat(maze.getStart(), is(start));
    Assert.assertThat(maze.getTarget(), is(target));
  }
}