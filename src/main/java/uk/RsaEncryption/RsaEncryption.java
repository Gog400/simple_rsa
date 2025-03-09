package uk.RsaEncryption;

import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigDecimal;

public class RsaEncryption {

    public BigDecimal encryptMessage(KeyPairEntity keyPair, int message) {
        BigDecimal power = BigDecimal.valueOf(message).pow(keyPair.getPublicKey());
        BigDecimal product = BigDecimal.valueOf(keyPair.getGenerationDetails().getProduct());
        return power.remainder(product);
    }

    public BigDecimal decryptMessage(KeyPairEntity keyPair, BigDecimal cipherMessage) {
        BigDecimal power = cipherMessage.pow(keyPair.getPrivateKey());
        BigDecimal product = BigDecimal.valueOf(keyPair.getGenerationDetails().getProduct());

        return power.remainder(product);
    }
}
