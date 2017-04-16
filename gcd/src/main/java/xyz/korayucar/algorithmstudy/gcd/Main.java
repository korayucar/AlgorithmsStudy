package xyz.korayucar.algorithmstudy.gcd;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by koray on 16/04/17.
 */
public class Main {

    private static final boolean INTERACTIVE = true;
    public static final BigInteger VERY_BIG_NUMBER =new BigInteger("182763597364593726358265386123861927356821657348");

    public static void main(String[] args) {
        Gcd gcd = new EuclidsGcd();
        if (INTERACTIVE) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter the first number for gcd calculation: ");
                BigInteger a = new BigInteger(scanner.next());
                System.out.print("Enter the second number for gcd calculation: ");
                BigInteger b = new BigInteger(scanner.next());
                timeGcd(gcd, a, b);
            }
        } else {
            Random random = new Random();
            BigInteger a = new BigInteger("6");
            for (long i = 1; i < 20; i++) {
                a = a.multiply(new BigInteger( ""+(random.nextInt(20)+2)));
                timeGcd(gcd, a, VERY_BIG_NUMBER);
            }
        }
    }


    private static void timeGcd(Gcd gcd, BigInteger a, BigInteger b) {
        Stopwatch timer = new Stopwatch().start();
        BigInteger gcdResult = gcd.gcdOf(a, b);
        System.out.println(toGcdResult(a, b, gcdResult) + "Execution took " + timer.stop());
    }

    private static String toGcdResult(BigInteger a, BigInteger b, BigInteger gcdResult) {
        String result = "Gcd of " + a + " and " + b + " is " + gcdResult;
        return result + Strings.repeat(" ", Math.max(0, 80 - result.length())) + (result.length() > 80 ? "\n" : "");
    }
}
