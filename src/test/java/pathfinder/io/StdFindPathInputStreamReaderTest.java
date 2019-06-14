package pathfinder.io;

import org.junit.Assert;
import org.junit.Test;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import static org.hamcrest.CoreMatchers.is;

public class StdFindPathInputStreamReaderTest {

    @Test
    public void verifyMazeBuiltFromStream() throws UnsupportedEncodingException {
        var mazeString = "...\nS..\n.#X\n...\n\n";
        var mazeInputStream = new ByteArrayInputStream(mazeString.getBytes("UTF-8"));

        var stdFindPathReader = new StdFindPathInputStreamReader(mazeInputStream);

        Maze maze = stdFindPathReader.readMaze();

        Assert.assertNotNull(maze.getStart());
        Assert.assertThat(maze.getStart().getPosition(), is(new Position(1, 0)));
        Assert.assertNotNull(maze.getTarget());
        Assert.assertThat(maze.getTarget().getPosition(), is(new Position(2, 2)));
        Assert.assertThat(maze.reachableNeighboursFor(maze.getStart()).size(), is(3));
    }
}