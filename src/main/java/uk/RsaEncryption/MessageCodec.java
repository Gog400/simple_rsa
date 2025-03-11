package uk.RsaEncryption;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class MessageCodec {

    private final Charset US_ASCII = StandardCharsets.US_ASCII;

    private final int DIGITS = 3;

    public BigInteger convertTextToNumber(String text) {
        StringBuilder sb = new StringBuilder().append("111"); // padding for number conversion Todo decryption security risk

        for(byte asciiCharacter : text.getBytes(US_ASCII)){
            sb.append(String.format(
                    "%0" + DIGITS + "d",
                    Integer.parseInt(String.valueOf(asciiCharacter))));
        }

        return new BigInteger(sb.toString());
    }

    public String convertNumberToText(BigInteger bigInt) {
        StringBuilder sb = new StringBuilder();
        String bigIntAsString = bigInt.toString();

        for (int i = DIGITS; i < bigIntAsString.length(); i += DIGITS) {
            sb.append((char) Integer.parseInt(bigIntAsString.substring(i, i+DIGITS)));
        }

        return sb.toString();
    }

}
