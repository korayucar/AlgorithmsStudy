package xyz.korayucar.algorithmstudy.peak.finder;

/**
 * Created by koray on 03/04/17.
 */
public class BruteForcePeakFinderTest extends PeakFinderTest {

    @Override
    PeakFinder createPeakFinder() {
        return new BruteForcePeakFinder();
    }
}