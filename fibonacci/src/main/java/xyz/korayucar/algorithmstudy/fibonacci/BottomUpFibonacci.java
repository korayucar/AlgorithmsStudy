package xyz.korayucar.algorithmstudy.fibonacci;

import java.math.BigInteger;

/**
 * Created by koray on 16/04/17.
 */
public class BottomUpFibonacci implements Fibonacci {


    @Override
    public BigInteger getFibonacciNumberByIndex(long indexOfFibonacciNumber) {
        if(indexOfFibonacciNumber == 0)
            return BigInteger.ZERO;
        if(indexOfFibonacciNumber == 1)
            return BigInteger.ONE;
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;
        for(int i = 2;i <= indexOfFibonacciNumber;i++)
        {
            BigInteger nextFibonacciNumber = previous.add (current);
            previous = current;
            current = nextFibonacciNumber;
        }
        return current;
    }
}
