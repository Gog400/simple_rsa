package uk.AesEncryption;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AesBase {

    public static final int KEY_BIT = 128;

    public byte[] convertIntToByte(BigInteger key) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(key.intValue()).array();
    }

    public BigInteger convertByteToInt(byte[] key) {
        return new BigInteger(ByteBuffer.wrap(key).order(ByteOrder.BIG_ENDIAN).array());
    }
}
