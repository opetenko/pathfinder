package pathfinder.io;

import java.io.InputStream;
import pathfinder.domain.Maze;

public interface MazeReader {

  Maze readMaze();

  static MazeReader fromInputStream(InputStream inputStream) {
    return new StdFindPathInputStreamReader(inputStream);
  }
}
