package uk.RsaEncryption;

import uk.RsaEncryption.Entity.GenerationDetails;
import uk.RsaEncryption.Entity.KeyPairEntity;

import static org.apache.commons.math3.primes.Primes.nextPrime;

public class KeyGenerator extends RsaBase{

    public static final RsaValidation rsaValidation = new RsaValidation();

    private int generatePublicKey(int totient) {
        int publicKey = nextPrime(randInt(MIN_NUMBER, totient));
        while (rsaValidation.checkIfPublicKeyIsValid(publicKey, totient)) { // ToDO kinda ugly
            publicKey = nextPrime(randInt(MIN_NUMBER, totient));
        }

        return publicKey;
    }

    private int generatePrivateKey(int publicKey, int totient) {
        int privateKey = randInt(MIN_NUMBER, MAX_NUMBER);
        while (rsaValidation.checkIfPrivateKeyIsValid(publicKey, privateKey, totient)) { // ToDO kinda ugly
            privateKey = randInt(MIN_NUMBER, MAX_NUMBER);
        }

        return privateKey;
    }

    public KeyPairEntity generateKeyPair() {
        int p = nextPrime(randInt(MIN_NUMBER, MAX_NUMBER));
        int q = nextPrime(randInt(MIN_NUMBER, MAX_NUMBER));
        int product = findProduct(p, q);
        int totient = findTotient(p, q);

        int publicKey = generatePublicKey(totient);
        int privateKey = generatePrivateKey(publicKey, totient);

        return new KeyPairEntity(
                publicKey,
                privateKey,
                new GenerationDetails(p, q, product, totient));
    }
}
