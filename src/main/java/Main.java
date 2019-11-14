import counters.Counter;
import counters.SimpleCounter;
import counters.StreamCounter;
import counters.ThreadCounter;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Быстрее всего работает TreadCounter, после него SimpleCounter и хуже всего StreamCounter

        int[] array = new Random().ints(100_000).toArray();
        Counter simpleCounter = new SimpleCounter();
        Counter threadCounter = new ThreadCounter();
        Counter streamCounter = new StreamCounter();

        LocalTime start = LocalTime.now();
        int count = simpleCounter.count(array);
        Duration duration = Duration.between(start, LocalTime.now());
        System.out.println("Simple SUM: " + count + " TIME: " + duration.toNanos());

        start = LocalTime.now();
        count = threadCounter.count(array);
        duration = Duration.between(start, LocalTime.now());
        System.out.println("Thread SUM: " + count + " TIME: " + duration.toNanos());

        start = LocalTime.now();
        count = streamCounter.count(array);
        duration = Duration.between(start, LocalTime.now());
        System.out.println("Stream SUM: " + count + " TIME: " + duration.toNanos() + "\n");
    }
}
