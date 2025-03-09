package uk.RsaEncryption;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RsaBase {

    public static final int BIT_LENGTH = 512;
    public static final Random rand = new SecureRandom();

    protected BigInteger findProduct(BigInteger p, BigInteger q) {
        return p.multiply(q);
    }

    protected BigInteger findTotient(BigInteger p, BigInteger q) {
        BigInteger pSub = p.subtract(BigInteger.ONE);
        BigInteger qSub = q.subtract(BigInteger.ONE);

        return pSub.multiply(qSub);
    }

    protected static BigInteger randPrime() {
        return BigInteger.probablePrime(BIT_LENGTH, rand);
    }

    protected static void regenerateIfPrimesAreEqual(BigInteger p, BigInteger q) {
        while (p.compareTo(q) == 0) {
            q = randPrime();
        }
    }
}
