package benchmark;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import pathfinder.domain.Maze;
import pathfinder.io.MazeReader;
import pathfinder.solver.BfsPathFinder;
import pathfinder.solver.DfsPathFinder;
import pathfinder.solver.path.Direction;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(1)
public class PathFinderBenchmarkTest {

  @State(Scope.Thread)
  public static class MazeState {

    InputStream mazeInputStream = getClass().getResourceAsStream("/maze.txt");
    MazeReader stdFindPathReader = MazeReader.fromInputStream(mazeInputStream);
    public Maze maze = stdFindPathReader.readMaze();
  }

  @Benchmark
  public List<Direction> dfsSearch(MazeState state) {
    return new DfsPathFinder().findPath(state.maze);
  }

  @Benchmark
  public List<Direction> bfsSearch(MazeState state) {
    return new BfsPathFinder().findPath(state.maze);
  }
}
