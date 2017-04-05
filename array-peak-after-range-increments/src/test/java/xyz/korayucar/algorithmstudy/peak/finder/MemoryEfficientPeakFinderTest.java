package xyz.korayucar.algorithmstudy.peak.finder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray on 03/04/17.
 */
public class MemoryEfficientPeakFinderTest extends PeakFinderTest {

    @Override
    PeakFinder createPeakFinder() {
        return new MemoryEfficientPeakFinder();
    }

    @Test(timeout = 2000)
    public void simplePeakFinder_VeryBigArrayIncrementedManyTimes_GivesExpectedPeakInTime() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(1<<30);
        for(int i = 1; i < 100000; i++)
            peakFinder.increment(0, i, 1<<12);
        assertEquals(99999 * (1<<12), peakFinder.getMax());
    }
}