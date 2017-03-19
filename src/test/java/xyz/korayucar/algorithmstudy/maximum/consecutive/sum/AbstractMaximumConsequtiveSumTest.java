package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

import org.junit.Test;

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

    @Test(timeout = 2000)
    public void performanceTest() {
        long [] arr = new long[1000000];
        for(int i = 0;i < arr.length;i++ )
            arr[i] = i%3 != 0 ? -1000 : 2000;
        assertMaxSum(arr, 2000);
    }


    abstract MaximumConsecutiveSum createMaximumConsequtiveSum();

    private void assertMaxSum(long[] arr, int expected) {
        long capacity = createMaximumConsequtiveSum().maxConsequtiveSum(arr);
        assertEquals(expected, capacity);
    }
}
