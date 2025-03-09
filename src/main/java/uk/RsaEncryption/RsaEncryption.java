package uk.RsaEncryption;

import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;

public class RsaEncryption {

    public BigInteger encryptMessage(KeyPairEntity keyPair, BigInteger message) {
        return message.modPow(keyPair.getPublicKey(), keyPair.getGenerationDetails().getProduct());
    }

    public BigInteger decryptMessage(KeyPairEntity keyPair, BigInteger cipherMessage) {
        return cipherMessage.modPow(keyPair.getPrivateKey(), keyPair.getGenerationDetails().getProduct());
    }
}
