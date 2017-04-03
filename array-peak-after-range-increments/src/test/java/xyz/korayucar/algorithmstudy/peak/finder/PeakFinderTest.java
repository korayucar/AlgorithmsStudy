package xyz.korayucar.algorithmstudy.peak.finder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by koray on 03/04/17.
 */
public abstract class PeakFinderTest {

    abstract PeakFinder createPeakFinder();

    @Test(expected = IllegalStateException.class)
    public void uninitializedPeakFinder_attemptToIncrement_throwsIllegalStateException() throws Exception {
        createPeakFinder().increment(0,0,1);
    }

    @Test(expected = IllegalStateException.class)
    public void intializedPeakFinder_Initialize_ThrowsIllegalStateException() throws Exception {
        PeakFinder peakFinder= createPeakFinder();
        peakFinder.init(2);
        peakFinder.init(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newlyCreatedPeakFinder_attemptToIncrementWithIllegalArguments_throwsIllegalArgumentException() throws Exception {
        PeakFinder peakFinder= createPeakFinder();
        peakFinder.init(2);
        peakFinder.increment(1, 0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void newlyCreatedPeakFinder_attemptToIncrementWithOutOfBoundStartIndex_throwsIndexOutOfBoundsException() throws Exception {
        PeakFinder peakFinder= createPeakFinder();
        peakFinder.init(1);
        peakFinder.increment(-1, 0, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void newlyCreatedPeakFinder_attemptToIncrementWithOutOfBoundEndIndex_throwsIndexOutOfBoundsException() throws Exception {
        PeakFinder peakFinder= createPeakFinder();
        peakFinder.init(1);
        peakFinder.increment(0, 2, 1);
    }


    @Test
    public void simplePeakFinder_incrementedFewTimes_givesExpectedPeak() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(6);
        peakFinder.increment(0, 1, 100);
        peakFinder.increment(1, 4, 100);
        peakFinder.increment(2, 3, 100);
        assertEquals(200, peakFinder.getMax());

    }

    @Test
    public void simplePeakFinder_incrementedFewTimes_givesExpectedPeak2() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(6);
        peakFinder.increment(1, 2, 603);
        peakFinder.increment(0, 0, 286);
        peakFinder.increment(3, 3, 882);
        assertEquals(882, peakFinder.getMax());

    }

    @Test(timeout = 2000)
    public void moderatelyLargeArray_TwoOverlappingIncrements_givesExpectedPeakInTime() throws Exception {
        PeakFinder peakFinder = createPeakFinder();
        peakFinder.init(600000);
        peakFinder.increment(1, 599999, 1<<25);
        peakFinder.increment(0, 599998, 1<<25);
        assertEquals(1<<26, peakFinder.getMax());

    }
}