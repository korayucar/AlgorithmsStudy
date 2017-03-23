package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/*
 * @author koray, @date 3/14/17 2:17 PM
 */
public abstract class AbstractMaximumConsequtiveSumTest {


    @Test
    public void maxSumIsZeroOnNonPositiveArray() {
        long [] arr = { -4 , -1,-3,-4, 0};
        assertMaxSum(arr, 0);
    }

    @Test
    public void maxSumIsZeroOntiveNegativeArray() {
        long [] arr = { -4 , -1,-3,-4};
        assertMaxSum(arr, 0);
    }


    @Test
    public void allPositiveArrayIsMaximumWithAllElementsIncluded() {
        long [] arr = { 4 , 1,3,4};
        assertMaxSum(arr, 12);
    }

    @Test
    public void singlePositiveIsMaximum() {
        long [] arr = { 4,4,4,4,4,4 , -30,400};
        assertMaxSum(arr, 400);
    }



    abstract MaximumConsecutiveSum createMaximumConsequtiveSum();

    protected void assertMaxSum(long[] arr, int expected) {
        long capacity = createMaximumConsequtiveSum().maxConsequtiveSum(arr);
        assertEquals(expected, capacity);
    }
}
