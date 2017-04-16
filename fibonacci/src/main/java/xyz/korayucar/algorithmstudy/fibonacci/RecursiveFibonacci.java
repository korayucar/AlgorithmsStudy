package xyz.korayucar.algorithmstudy.fibonacci;

import java.math.BigInteger;

/**
 * Created by koray on 16/04/17.
 */
public class RecursiveFibonacci implements Fibonacci {

    @Override
    public BigInteger getFibonacciNumberByIndex(long indexOfFibonacciNumber) {
        if(indexOfFibonacciNumber == 0)
            return BigInteger.ZERO;
        if(indexOfFibonacciNumber == 1)
            return BigInteger.ONE;
        return getFibonacciNumberByIndex(indexOfFibonacciNumber - 1).add(getFibonacciNumberByIndex(indexOfFibonacciNumber-2));
    }

}
