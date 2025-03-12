package uk.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import uk.RsaEncryption.Entity.KeyPairEntity;
import uk.RsaEncryption.KeyGenerator;
import uk.RsaEncryption.MessageCodec;
import uk.RsaEncryption.RsaEncryption;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestRsaEncryption {

    @ParameterizedTest(name = "[{index}] Used message: {arguments})")
    @ValueSource(strings = {"311", "231431", "12", "93130", "231dsad", "dsadfvD", "hello world"})
    @DisplayName("Check RSA encryption with random message. Positive case.")
    public void successRsaEncryption(String message) {
        KeyGenerator keyGenerator = new KeyGenerator();
        RsaEncryption rsaEncryption = new RsaEncryption();
        MessageCodec messageCodec = new MessageCodec();

        KeyPairEntity keyPair2 = keyGenerator.generateKeyPair();
        System.out.println(keyPair2);

        System.out.println("Original message: " + message);

        // sign message

        BigInteger cipherMessage = rsaEncryption.encryptMessage(keyPair2, messageCodec.convertTextToNumber(message));
        System.out.println("encrypted message: " + cipherMessage);

        BigInteger decryptedMessage = rsaEncryption.decryptMessage(keyPair2, cipherMessage);
        System.out.println("decrypted message: " + decryptedMessage);

        // validate signature

        assertNotEquals(message, cipherMessage);
        assertEquals(message, messageCodec.convertNumberToText(decryptedMessage));
    }
}
