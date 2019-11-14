package counters.threads;

public class NumbersRunner implements Runnable {

    private int[] values;
    private int[] out;
    private int startPos;
    private int endPos;
    private int index;

    @Override
    public void run() {
        int count = 0;
        for (int i = startPos; i < endPos; i++) {
            count += values[i];
        }
        out[index] = count;
    }

    public NumbersRunner(int[] values, int startPos, int endPos, int[] out, int index) {
        this.values = values;
        this.startPos = startPos;
        this.endPos = endPos;
        this.out = out;
        this.index = index;
    }
}

