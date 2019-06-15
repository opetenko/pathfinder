package benchmark;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmhBenchmarkTest {

  @Test
  public void runJmhBenchmark() throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(PathFinderBenchmarkTest.class.getSimpleName())
        .warmupIterations(2)
        .measurementIterations(5)
        .build();
    new Runner(opt).run();
  }
}
