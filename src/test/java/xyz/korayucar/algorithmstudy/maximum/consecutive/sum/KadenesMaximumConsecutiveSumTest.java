package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

/**
 * @author koray
 * @version 3/14/17 3:53 PM.
 */
public class KadenesMaximumConsecutiveSumTest extends AbstractMaximumConsequtiveSumTest {

    @Override
    MaximumConsecutiveSum createMaximumConsequtiveSum() {
        return new KadenesMaximumConsecutiveSum();
    }


}