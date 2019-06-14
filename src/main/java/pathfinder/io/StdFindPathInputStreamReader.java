package pathfinder.io;

import pathfinder.domain.builder.ElementFactory;

import java.io.InputStream;

class StdFindPathInputStreamReader extends AbstractFindPathInputReader {

    protected StdFindPathInputStreamReader(InputStream inputStream) {
        super(inputStream, new ElementFactory());
    }
}
