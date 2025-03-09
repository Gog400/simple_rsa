package uk.RsaEncryption;

import lombok.SneakyThrows;
import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Objects;

public class RsaValidation {

    RsaEncryption rsaEncryption = new RsaEncryption();

    public boolean checkIfPublicKeyIsValid(BigInteger publicKey, BigInteger totient) {
        boolean isPrime = publicKey.isProbablePrime(1);
        boolean isLessThanTotient = publicKey.compareTo(totient) < 0;
        boolean isNotAFactorOfATotient = totient.mod(publicKey).compareTo(BigInteger.ZERO) != 0;

        return isPrime && isLessThanTotient && isNotAFactorOfATotient;
    }

    @SneakyThrows
    public boolean checkMessageSignature(KeyPairEntity keyPairEntity, BigInteger decryptedMessage, BigInteger signedMessage, EHashAlg hashAlg) {
        MessageDigest md = MessageDigest.getInstance(hashAlg.getAlgName());
        BigInteger hashedMessage = new BigInteger(1, md.digest(decryptedMessage.toByteArray()));
        System.out.println("hashed message by verifier: " + hashedMessage);

        return hashedMessage.equals(rsaEncryption.encryptMessage(keyPairEntity, signedMessage));

    }
}
