package uk.RsaEncryption;

import static org.apache.commons.math3.primes.Primes.isPrime;

public class RsaValidation {

    public boolean checkIfPublicKeyIsValid(int publicKey, int totient) {
        return (isPrime(publicKey)) && (publicKey > totient) && (totient % publicKey != 0);
    }

    public boolean checkIfPrivateKeyIsValid(int publicKey, int privateKey, int totient) {
        return (publicKey * privateKey) / totient == 1;
    }
}
