package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

/**
 * Created by koray on 19/03/17.
 */
public class VeryInefficientMaxConsequtiveSumTest extends AbstractMaximumConsequtiveSumTest {

    @Override
    MaximumConsecutiveSum createMaximumConsequtiveSum() {
        return new VeryInefficientMaxConsequtiveSum();
    }
}