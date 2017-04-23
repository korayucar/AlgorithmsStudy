package xyz.korayucar.algorithmstudy.pair.sum;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author koray
 * @version 4/18/17 7:50 PM.
 */
public class Main {


    private static boolean INTERACTIVE = false;

    public static void main(String[] args) {

        PairSum pairSum = null;// TODO insert your algorith here ie: new BruteForcePairSum();
        if(INTERACTIVE){
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.print("Gimme space separated integers then press enter: ");
                long[] arr = Arrays.stream(scanner.nextLine().split("\\s"))
                        .mapToLong(Long::valueOf)
                        .toArray();
                System.out.print("Gimme the number to check if any pair of integers sums up to:");
                long sum = scanner.nextLong();
                scanner.nextLine();
                timePairSum(pairSum, arr,sum);
            }
        }
        else {

            Random random = new Random();
            for(int i = 1,k=1; i < (1<<30); i <<=1,k++ ) {
//                System.out.print("Trying with input size " + i + " ");
                System.out.print(   i+" " );
                long[] arr = new long[i];
                for(int j =0;j<i;j++)
                    arr[j] = random.nextLong()%300+1;
                timePairSum(pairSum,arr,600);
            }

        }
    }


    private static void timePairSum(PairSum pairSum, long[] arr, long sum) {
        Stopwatch timer = Stopwatch.createStarted();
        boolean exists = pairSum.hasPair(arr, sum);
        System.out.println(timer.stop().elapsed(TimeUnit.MICROSECONDS));
    }

    private static String getResultString(boolean exists) {
        if(exists)
            return "There is at least one pair.";
        else
            return "No pair found.";
    }
}
