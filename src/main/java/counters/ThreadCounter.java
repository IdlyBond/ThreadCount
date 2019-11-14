package counters;

import counters.threads.NumbersRunner;

import java.util.Objects;

public class ThreadCounter implements Counter {

    private static final int MAX_THREADS = 10;


    @Override
    public int count(int[] values) {
        if (Objects.isNull(values))
            throw new NullPointerException("Array must not be NULL");

        int[] count = new int[MAX_THREADS];
        int length = Math.floorDiv(values.length, MAX_THREADS);
        int position = 0;

        for (int i = 0; i < MAX_THREADS - 1; i++) {
            new NumbersRunner(values, position, position =+ length, count, i).run();
        }
        new NumbersRunner(values, position, values.length, count, MAX_THREADS - 1).run();

        int out = 0;

        for (int item : count) {
            out += item;
        }

        return out;

    }
}
