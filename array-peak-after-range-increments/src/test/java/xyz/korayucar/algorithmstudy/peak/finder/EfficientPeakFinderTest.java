package xyz.korayucar.algorithmstudy.peak.finder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray on 03/04/17.
 */
public class EfficientPeakFinderTest extends PeakFinderTest {

    @Override
    PeakFinder createPeakFinder() {
        return new EfficientPeakFinder();
    }

    @Test(timeout = 2000)
    public void simplePeakFinder_incrementedFewTimes_givesExpectedPeak() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(1<<30);
        for(int i = 0; i < 100000; i++)
            peakFinder.increment(0, i, 1<<12);
        assertEquals(100000 * (1<<12), peakFinder.getMax());
    }
}