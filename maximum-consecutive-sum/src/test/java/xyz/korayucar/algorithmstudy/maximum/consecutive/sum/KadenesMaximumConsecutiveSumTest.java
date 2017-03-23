package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

import org.junit.Test;

/**
 * @author koray
 * @version 3/14/17 3:53 PM.
 */
public class KadenesMaximumConsecutiveSumTest extends AbstractMaximumConsequtiveSumTest {

    @Override
    MaximumConsecutiveSum createMaximumConsequtiveSum() {
        return new KadenesMaximumConsecutiveSum();
    }



    @Test(timeout = 2000)
    public void performanceTest() {
        long [] arr = new long[1000000];
        for(int i = 0;i < arr.length;i++ )
            arr[i] = i%3 != 0 ? -1000 : 2000;
        assertMaxSum(arr, 2000);
    }
}