package uk.RsaEncryption;

import lombok.SneakyThrows;
import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RsaEncryption {

    public BigInteger encryptMessage(KeyPairEntity keyPair, BigInteger message) {
        return message.modPow(keyPair.getPublicKey(), keyPair.getGenerationDetails().getProduct());
    }

    public BigInteger decryptMessage(KeyPairEntity keyPair, BigInteger cipherMessage) {
        return cipherMessage.modPow(keyPair.getPrivateKey(), keyPair.getGenerationDetails().getProduct());
    }

    @SneakyThrows
    public BigInteger signMessage(KeyPairEntity keyPair, BigInteger message, EHashAlg hashAlg) {
        MessageDigest md = MessageDigest.getInstance(hashAlg.getAlgName());
        BigInteger hashedMessage = new BigInteger(1, md.digest(message.toByteArray()));
        System.out.println("hashed message by signer: " + hashedMessage);

        return decryptMessage(keyPair, hashedMessage);
    }
}
