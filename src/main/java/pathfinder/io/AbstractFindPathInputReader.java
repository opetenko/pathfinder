package pathfinder.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pathfinder.domain.Cell;
import pathfinder.domain.Element;
import pathfinder.domain.Maze;
import pathfinder.domain.Position;
import pathfinder.domain.builder.ElementFactory;
import pathfinder.domain.builder.MazeBuilder;

abstract class AbstractFindPathInputReader implements MazeReader {

  private final InputStream inputStream;
  private final ElementFactory elementFactory;

  protected AbstractFindPathInputReader(InputStream inputStream, ElementFactory elementFactory) {
    this.inputStream = inputStream;
    this.elementFactory = elementFactory;
  }

  @Override
  public Maze readMaze() {
    try (var reader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      MazeBuilder mazeBuilder = new MazeBuilder();
      List<String> lines = reader.lines()
          .takeWhile(s -> !s.isEmpty())
          .collect(Collectors.toList());
      validateBoard(lines);
      int rows = lines.size();
      int cols = lines.get(0).length();
      mazeBuilder.withDimensions(rows, cols);
      buildGrid(lines, mazeBuilder, rows, cols);
      return mazeBuilder.build();
    } catch (IOException e) {
      throw new RuntimeException("IO problems while read maze from input stream");
    }
  }

  private void validateBoard(List<String> input) {
    if (input.isEmpty()) {
      throw new RuntimeException("Input is empty");
    }
    int len = input.get(0).length();
    boolean allSameSize = input.stream().allMatch(x -> x.length() == len);
    if (!allSameSize) {
      throw new RuntimeException("Not rectangular grid");
    }
  }

  private void buildGrid(List<String> input, MazeBuilder mazeBuilder, int rows, int cols) {
    var grid = new ArrayList<Cell>(rows * cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        Element element = elementFactory.build(input.get(i).charAt(j));
        Cell cell = buildCell(element, new Position(i, j), rows, cols);
        if (element == Element.START) {
          mazeBuilder.withStart(cell);
        }
        if (element == Element.TARGET) {
          mazeBuilder.withTarget(cell);
        }
        grid.add(cell);
      }
    }
    mazeBuilder.withGrid(grid);
  }

  private Cell buildCell(Element value, Position position, int rows, int cols) {
    return new Cell(position, value, getNeighbours(position, rows, cols));
  }

  private List<Position> getNeighbours(Position position, int rows, int cols) {
    var shift = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});
    List<Position> positions = new ArrayList<>();
    for (int[] pair : shift) {
      int i = pair[0];
      int j = pair[1];
      Position newPosition = new Position(position.getRow() + i, position.getColumn() + j);
      if (isInBoard(newPosition, rows, cols)) {
        positions.add(newPosition);
      }
    }
    return positions;
  }

  private boolean isInBoard(Position position, int rows, int cols) {
    return inRange(position.getRow(), rows) && inRange(position.getColumn(), cols);
  }

  private boolean inRange(int position, int dimension) {
    return position >= 0 && position < dimension;
  }
}
