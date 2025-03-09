package uk;

import uk.RsaEncryption.Entity.KeyPairEntity;
import uk.RsaEncryption.KeyGenerator;
import uk.RsaEncryption.RsaEncryption;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        RsaEncryption rsaEncryption = new RsaEncryption();

        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
        System.out.println(keyPair2);

        BigInteger message = BigInteger.valueOf(1337);
        System.out.println("original message: " + message);

        BigInteger cipherMessage = rsaEncryption.encryptMessage(keyPair2, message);
        System.out.println("encrypted message: " + cipherMessage);

        BigInteger decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
        System.out.println("decrypted message: " + decryptedMessage);
    }
}
