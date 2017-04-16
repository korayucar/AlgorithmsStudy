package xyz.korayucar.algorithmstudy.gcd;

import java.math.BigInteger;

/**
 * Created by koray on 16/04/17.
 */
public class BruteForceGcd implements Gcd{
    @Override
    public BigInteger gcdOf(BigInteger a, BigInteger b) {
        if(a.compareTo(BigInteger.ZERO) < 1 || b.compareTo(BigInteger.ZERO) < 1)
            throw new IllegalArgumentException("both numbers must be positive integers");
        BigInteger min = a.min(b);
        for(BigInteger i = min ; i.compareTo(BigInteger.ZERO) > 0 ;i=i.subtract(BigInteger.ONE)){
            if(a.remainder(i).equals(BigInteger.ZERO) && b.remainder(i).equals(BigInteger.ZERO))
                return i;
        }
        throw new IllegalStateException("Could not find a gcd. Unexpected state. Indicates a bug.");
    }
}