package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

/**
 * @author koray
 * @version 3/14/17 3:53 PM.
 */
public class KadenesMaximumConsecutiveSum implements MaximumConsecutiveSum {
    @Override
    public long maxConsequtiveSum(long[] data) {

        long max_so_far = 0;
        long max_ending_here = 0;
        for (long num : data) {
            max_ending_here = Math.max(0, max_ending_here + num);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
