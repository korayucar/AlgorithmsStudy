package xyz.korayucar.algorithmstudy.gcd;

import java.math.BigInteger;

/**
 * Created by koray on 16/04/17.
 */
public class EuclidsGcd implements Gcd {


    @Override
    public BigInteger gcdOf(BigInteger a, BigInteger b) {
        if(a.compareTo(BigInteger.ZERO) < 1 || b.compareTo(BigInteger.ZERO) < 1)
            throw new IllegalArgumentException("both numbers must be positive integers");
        return doEuclidsGcd(a, b);
    }

    private BigInteger doEuclidsGcd(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO))
            return a;
        else
            return doEuclidsGcd(b, a.remainder(b));
    }
}
