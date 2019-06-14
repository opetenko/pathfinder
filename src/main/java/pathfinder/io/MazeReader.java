package pathfinder.io;

import pathfinder.domain.Maze;

import java.io.InputStream;

public interface MazeReader {
    Maze readMaze();

    static MazeReader fromInputStream(InputStream inputStream) {
        return new StdFindPathInputStreamReader(inputStream);
    }
}
