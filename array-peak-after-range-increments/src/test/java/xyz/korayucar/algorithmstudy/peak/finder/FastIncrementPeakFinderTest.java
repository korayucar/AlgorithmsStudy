package xyz.korayucar.algorithmstudy.peak.finder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray on 05/04/17.
 */
public class FastIncrementPeakFinderTest extends PeakFinderTest {

    @Override
    PeakFinder createPeakFinder() {
        return new FastIncrementPeakFinder();
    }

    @Test(timeout = 2000)
    public void simplePeakFinder_IncrementedManyTimes_GivesExpectedPeakInTime() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(1000);
        for(int i = 0; i < 10000000; i++)
            peakFinder.increment(0, 999, 1);
        assertEquals(10000000, peakFinder.getMax());
    }


}