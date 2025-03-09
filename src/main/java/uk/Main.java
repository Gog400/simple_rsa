package uk;

import uk.RsaEncryption.Entity.GenerationDetails;
import uk.RsaEncryption.Entity.KeyPairEntity;
import uk.RsaEncryption.KeyGenerator;
import uk.RsaEncryption.RsaEncryption;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        RsaEncryption rsaEncryption = new RsaEncryption();

//        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
//        System.out.println(keyPair2);

        KeyPairEntity keyPair2 = KeyPairEntity.builder()
                .publicKey(3)
                .privateKey(7)
                .generationDetails(new GenerationDetails(11, 3, 33, 20))
                .build();
        System.out.println(keyPair2);

        int message = 7;
        System.out.println("Original message: " + message);

        // fixme: stack overflow or wrong modulo
        BigDecimal cipherMessage = rsaEncryption.encryptMessage(keyPair2, message);
        System.out.println("encrypted message: " + cipherMessage);

        BigDecimal decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
        System.out.println("decrypted message: " + decryptedMessage);
    }
}
