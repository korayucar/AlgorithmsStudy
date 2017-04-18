package xyz.korayucar.algorithmstudy.pair.sum;

import java.util.Arrays;

/**
 * @author koray
 * @version 4/18/17 8:16 PM.
 */
public class EfficientPairSum implements PairSum{

    @Override
    public boolean hasPair(long[] arr, long sum) {
        if(arr == null)
            throw new NullPointerException();
        Arrays.sort(arr);
        int leftIndex = 0;
        int rightIndex = arr.length-1;
        while(leftIndex<rightIndex){
            long currentSum = arr[leftIndex] + arr[rightIndex];
            if(currentSum == sum)
                return true;
            if(currentSum > sum)
                rightIndex--;
            else
                leftIndex++;
        }
        return false;
    }
}
