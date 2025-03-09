package uk.steps;

import java.math.BigInteger;

public class RsaSteps {

    public boolean checkIfPrivateKeyIsValid(BigInteger publicKey, BigInteger privateKey, BigInteger totient) {
        return publicKey.multiply(privateKey).remainder(totient).compareTo(BigInteger.ONE) == 0;
    }

}
