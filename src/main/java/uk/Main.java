package uk;

import uk.RsaEncryption.EHashAlg;
import uk.RsaEncryption.Entity.KeyPairEntity;
import uk.RsaEncryption.KeyGenerator;
import uk.RsaEncryption.RsaEncryption;
import uk.RsaEncryption.RsaValidation;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        RsaEncryption rsaEncryption = new RsaEncryption();
        RsaValidation rsaValidation = new RsaValidation();
        EHashAlg hashAlg = EHashAlg.SHA_3_512;

        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
        System.out.println(keyPair2);

        BigInteger message = BigInteger.valueOf(1337);
        System.out.println("original message: " + message);

        // encryption and decryption process
        BigInteger cipherMessage = rsaEncryption.encryptMessage(keyPair2, message);
        System.out.println("encrypted message: " + cipherMessage);

        BigInteger decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
        System.out.println("decrypted message: " + decryptedMessage);

        // signature and verification process
        BigInteger signature = rsaEncryption.signMessage(keyPair2, message, hashAlg);
        System.out.println("signature: " + signature);

        boolean isValidSignature = rsaValidation.checkMessageSignature(keyPair2, decryptedMessage, signature, hashAlg);
        System.out.println("signature is valid: " + isValidSignature);
    }
}
