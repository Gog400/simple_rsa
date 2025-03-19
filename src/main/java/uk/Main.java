package uk;

import uk.AesEncryption.KeyExpansion;
import uk.RsaEncryption.*;
import uk.RsaEncryption.Entity.KeyPairEntity;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        KeyGenerator keyGenerator = new KeyGenerator();
//        RsaEncryption rsaEncryption = new RsaEncryption();
//        RsaValidation rsaValidation = new RsaValidation();
//        MessageCodec messageCodec = new MessageCodec();
//        EHashAlg hashAlg = EHashAlg.SHA_3_512;
//
//        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
//        System.out.println(keyPair2);
//
//        String message = "Hello guys!";
//        BigInteger encodedMessage = messageCodec.convertTextToNumber(message);
//        System.out.println("original message: " + message);
//        System.out.println("encoded message: " + encodedMessage);
//
//        // encryption and decryption process
//        BigInteger cipherMessage = rsaEncryption.encryptMessage(keyPair2, encodedMessage);
//        System.out.println("encrypted message: " + cipherMessage);
//
//        BigInteger decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
//        String decodedMessage = messageCodec.convertNumberToText(decryptedMessage);
//        System.out.println("decrypted message: " + decryptedMessage);
//        System.out.println("decoded message: " + decodedMessage);
//
//        // signature and verification process
//        BigInteger signature = rsaEncryption.signMessage(keyPair2, encodedMessage, hashAlg);
//        System.out.println("signature: " + signature);
//
//        boolean isValidSignature = rsaValidation.checkMessageSignature(keyPair2, decryptedMessage, signature, hashAlg);
//        System.out.println("signature is valid: " + isValidSignature);




        byte[] state = {
            0,  4,  8,  12,
            1,  5,  9,  13,
            2,  6,  10, 14,
            3,  7,  11, 15
        };

        System.out.println(Arrays.toString(state));

        KeyExpansion ke = new KeyExpansion();
        ke.rotateState(state);
        System.out.println(Arrays.toString(state));

    }
}
