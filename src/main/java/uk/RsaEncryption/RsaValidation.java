package uk.RsaEncryption;

import java.math.BigInteger;

public class RsaValidation {

    public boolean checkIfPublicKeyIsValid(BigInteger publicKey, BigInteger totient) {
        boolean isPrime = publicKey.isProbablePrime(1);
        boolean isLessThanTotient = publicKey.compareTo(totient) < 0;
        boolean isNotAFactorOfATotient = totient.mod(publicKey).compareTo(BigInteger.ZERO) != 0;

        return isPrime && isLessThanTotient && isNotAFactorOfATotient;
    }
}
