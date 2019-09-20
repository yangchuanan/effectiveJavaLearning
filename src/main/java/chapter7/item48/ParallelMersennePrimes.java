package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

/**
 * @Author Chuanan YANG
 * @DateTime 2019/9/7 18:59
 * @Description Parallel stream-based program to generate the first 20 Mersenne primes - HANGS!!! (Page 222)
 * @Version 0.0.1
 */
public class ParallelMersennePrimes {
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(System.out::println);
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
