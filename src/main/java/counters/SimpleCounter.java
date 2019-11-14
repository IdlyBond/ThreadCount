package counters;

import java.util.Objects;

public class SimpleCounter implements Counter {

    public int count(int[] values) {
        if(Objects.isNull(values))
            throw new NullPointerException("Array must not be NULL");
        int count = 0;
        for (int item: values) {
            count += item;
        }
        return count;
    }
}
