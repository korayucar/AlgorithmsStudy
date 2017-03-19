package xyz.korayucar.algorithmstudy.maximum.consecutive.sum;

/**
 * Created by koray on 19/03/17.
 */
public class InefficientMaxConsecutiveSum implements MaximumConsecutiveSum {
    @Override
    public long maxConsequtiveSum(long[] data) {

        if (data == null)
            throw new NullPointerException();

        if (data.length == 0)
            return 0;

        //sum of the array up to the indice
        long [] sums = new long[data.length];
        sums[0] = data[0];
        for (int i = 1; i < data.length ; i++) {
            sums[i] = sums[i-1] + data[i];
        }

        long maxSum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                long sumBeforeI = 0;
                if(i!=0)
                    sumBeforeI = sums[i-1];
                maxSum = Math.max(maxSum , sums[j] - sumBeforeI );
            }
        }
        return maxSum;
    }
}
