package xyz.korayucar.algorithmstudy.peak.finder;

/**
 * Created by koray on 05/04/17.
 */
public class FastIncrementPeakFinder implements PeakFinder {

    int[] data;

    @Override
    public void init(int arrayLength) {
        if (data != null)
            throw new IllegalStateException("FastIncrementPeakFinder has already been initialized.");
        data = new int[arrayLength + 1];
    }

    @Override
    public void increment(int startIndexInc, int endIndexInc, int delta) {
        validateIncrement(startIndexInc, endIndexInc);
        data[startIndexInc] += delta;
        data[endIndexInc+1] -= delta;
    }

    @Override
    public int getMax() {
        checkInitialized();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : data) {
            sum += i;
            max = Math.max(max, sum);
        }
        return max;
    }


    private void validateIncrement(int startIndexInc, int endIndexInc) {
        checkInitialized();
        if (startIndexInc < 0 || startIndexInc >= data.length || endIndexInc < 0 || endIndexInc > data.length)
            throw new IndexOutOfBoundsException("Indices are not in range.");
        if (endIndexInc <= startIndexInc)
            throw new IllegalArgumentException("End index must be bigger.");
    }


    private void checkInitialized() {
        if (data == null)
            throw new IllegalStateException("BruteForcePeakFinder must be initialized before use.");
    }
}
