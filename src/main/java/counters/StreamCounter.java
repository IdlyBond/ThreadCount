package counters;

import java.util.stream.IntStream;

public class StreamCounter implements Counter{

    @Override
    public int count(int[] values) {
        return IntStream.of(values).sum();
    }
}
