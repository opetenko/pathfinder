package pathfinder.io;

public final class FindPathInputReaderStdIn extends StdFindPathInputStreamReader {
    public FindPathInputReaderStdIn() {
        super(System.in);
    }
}
