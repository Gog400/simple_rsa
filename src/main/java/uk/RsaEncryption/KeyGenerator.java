package uk.RsaEncryption;

import uk.RsaEncryption.Entity.GenerationDetails;
import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;

public class KeyGenerator extends RsaBase{

    public static final RsaValidation rsaValidation = new RsaValidation();

    private BigInteger generatePublicKey(BigInteger totient) {
        BigInteger publicKey = randPrime();
        while (!rsaValidation.checkIfPublicKeyIsValid(publicKey, totient)) { // ToDO kinda ugly
            publicKey = randPrime();
        }

        return publicKey;
    }

    private BigInteger generatePrivateKey(BigInteger publicKey, BigInteger totient) {
        return publicKey.modInverse(totient);
    }

    public KeyPairEntity generateKeyPair() {
        BigInteger p = randPrime();
        BigInteger q = randPrime();
        regenerateIfPrimesAreEqual(p, q);

        BigInteger product = findProduct(p, q);
        BigInteger totient = findTotient(p, q);

        BigInteger publicKey = generatePublicKey(totient);
        BigInteger privateKey = generatePrivateKey(publicKey, totient);

        return new KeyPairEntity(
                publicKey,
                privateKey,
                new GenerationDetails(p, q, product, totient));
    }
}
