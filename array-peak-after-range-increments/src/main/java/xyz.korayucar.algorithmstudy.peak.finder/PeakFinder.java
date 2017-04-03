package xyz.korayucar.algorithmstudy.peak.finder;

/**
 * Created by koray on 03/04/17.
 */
public interface PeakFinder {


    void init(int arrayLength);

    void increment(int startIndexInc, int endIndexInc, int delta );

    int getMax();

}
