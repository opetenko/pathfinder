package pathfinder.io;

import java.io.InputStream;
import pathfinder.domain.builder.ElementFactory;

class StdFindPathInputStreamReader extends AbstractFindPathInputReader {

  protected StdFindPathInputStreamReader(InputStream inputStream) {
    super(inputStream, new ElementFactory());
  }
}
