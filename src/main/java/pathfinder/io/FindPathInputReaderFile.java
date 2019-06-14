package pathfinder.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public final class FindPathInputReaderFile extends StdFindPathInputStreamReader {

    public FindPathInputReaderFile(String fileName) throws FileNotFoundException {
        super(new FileInputStream(fileName));
    }
}
