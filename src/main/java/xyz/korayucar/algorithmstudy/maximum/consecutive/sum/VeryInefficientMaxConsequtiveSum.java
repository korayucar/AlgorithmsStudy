package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

/**
 * Created by koray on 19/03/17.
 */
public class VeryInefficientMaxConsequtiveSum implements MaximumConsecutiveSum {


    @Override
    public long maxConsequtiveSum(long[] data) {
        long maxSum =0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length ; j++) {
                long sum = 0;
                for (int k = i; k <= j ; k++) {
                    sum+=data[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }



}
