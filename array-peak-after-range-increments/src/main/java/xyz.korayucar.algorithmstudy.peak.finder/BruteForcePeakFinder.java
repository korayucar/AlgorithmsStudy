package xyz.korayucar.algorithmstudy.peak.finder;

import java.util.Arrays;

/**
 * @author osmanalper
 * @version 27/03/2017.
 */
public class BruteForcePeakFinder implements PeakFinder {

    int[] data;

    @Override
    public void init(int arrayLength) {
        if (data != null)
            throw new IllegalStateException("BruteForcePeakFinder has already been initialized.");
        data = new int[arrayLength];
    }

    @Override
    public void increment(int startIndexInc, int endIndexInc, int delta) {
        validateIncrement(startIndexInc, endIndexInc);
        for (; startIndexInc <= endIndexInc; startIndexInc++)
            data[startIndexInc] += delta;
    }

    @Override
    public int getMax() {
        checkInitialized();
        return Arrays.stream(data).max().getAsInt();
    }

    private void validateIncrement(int startIndexInc, int endIndexInc) {
        checkInitialized();
        if (startIndexInc < 0 || startIndexInc >= data.length || endIndexInc < 0 || endIndexInc > data.length)
            throw new IndexOutOfBoundsException("Indices are not in range.");
        if (endIndexInc < startIndexInc)
            throw new IllegalArgumentException("Start index cannot be bigger than end index");
    }


    private void checkInitialized() {
        if (data == null)
            throw new IllegalStateException("BruteForcePeakFinder must be initialized before use.");
    }
}
