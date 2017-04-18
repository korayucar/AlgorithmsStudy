package xyz.korayucar.algorithmstudy.pair.sum;

/**
 * @author koray
 * @version 4/18/17 8:03 PM.
 */
public class BruteForcePairSum implements PairSum {

    @Override
    public boolean hasPair(long[] arr, long sum) {
        if(arr == null)
            throw new NullPointerException();
        boolean found =false;
        for (int i = 0; i < arr.length; i++)
            for (int j = i+1; j < arr.length; j++) {
                found |= arr[i]+arr[j] == sum;
            }
        return found;
    }
}
