package uk;

import uk.RsaEncryption.*;
import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        RsaEncryption rsaEncryption = new RsaEncryption();
        RsaValidation rsaValidation = new RsaValidation();
        MessageCodec messageCodec = new MessageCodec();
        EHashAlg hashAlg = EHashAlg.SHA_3_512;

        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
        System.out.println(keyPair2);

        String message = "Hello guys!";
        BigInteger encodedMessage = messageCodec.convertTextToNumber(message);
        System.out.println("original message: " + message);
        System.out.println("encoded message: " + encodedMessage);

        // encryption and decryption process
        BigInteger cipherMessage = rsaEncryption.encryptMessage(keyPair2, encodedMessage);
        System.out.println("encrypted message: " + cipherMessage);

        BigInteger decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
        String decodedMessage = messageCodec.convertNumberToText(decryptedMessage);
        System.out.println("decrypted message: " + decryptedMessage);
        System.out.println("decoded message: " + decodedMessage);

        // signature and verification process
        BigInteger signature = rsaEncryption.signMessage(keyPair2, encodedMessage, hashAlg);
        System.out.println("signature: " + signature);

        boolean isValidSignature = rsaValidation.checkMessageSignature(keyPair2, decryptedMessage, signature, hashAlg);
        System.out.println("signature is valid: " + isValidSignature);

    }
}
