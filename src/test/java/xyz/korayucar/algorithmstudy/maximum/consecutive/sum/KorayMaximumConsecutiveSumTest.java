package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

import static org.junit.Assert.*;

/**
 * @author koray
 * @version 3/14/17 3:53 PM.
 */
public class KorayMaximumConsecutiveSumTest extends AbstractMaximumConsequtiveSumTest {

    @Override
    MaximumConsecutiveSum createMaximumConsequtiveSum() {
        return new KorayMaximumConsecutiveSum();
    }


}