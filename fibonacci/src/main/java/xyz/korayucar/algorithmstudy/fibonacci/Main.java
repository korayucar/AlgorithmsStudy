package xyz.korayucar.algorithmstudy.fibonacci;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by koray on 16/04/17.
 */
public class Main {

    private static final boolean INTERACTIVE = true;

    public static void main(String[] args) {
        Fibonacci fibonacci = new BottomUpFibonacci();
        if (INTERACTIVE) {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.print("Enter index of the fibonacci number: ");
                timeFibonacciNumber(fibonacci, scanner.nextLong());
            }
        } else {
            for (int i = 0; i < 300; i++)
                timeFibonacciNumber(fibonacci, i);
        }
    }








    private static void timeFibonacciNumber(Fibonacci fibonacci, long index) {
        Stopwatch timer = new Stopwatch().start();
        BigInteger fibonacciNumber = fibonacci.getFibonacciNumberByIndex(index);
        System.out.println(toFibonacciResult(index, fibonacciNumber) + "Excecution took " + timer.stop());
    }

    private static String toFibonacciResult(long index, BigInteger fibonacciNumber) {
        String result = index + " ==> " +fibonacciNumber;
        return result + Strings.repeat(" ", Math.max(0,80 - result.length())) + (result.length() > 80 ? "\n" : "");
    }
}
