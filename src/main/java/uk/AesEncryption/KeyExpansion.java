package uk.AesEncryption;

import java.math.BigInteger;

public class KeyExpansion extends AesBase {


//    public byte[] state = {
//            0,  1,  2,  3,
//            4,  5,  6, 7,
//            8,  9,  10, 11,
//            12,  13,  14, 15
//    };
//
//    public byte[] state = {
//            0,  1,    2,  3,
//            5,  6,    7,  4,
//            10, 11,   8,  9,
//            15, 12,   13, 14,
//    };

    public void expandKey(byte[] byteArray, int rConIteration) {

    }

    public byte[] rotateState(byte[] state) {
        byte[] temp = new byte[16];

        temp[0] = state[0];
        temp[1] = state[1];
        temp[2] = state[2];
        temp[3] = state[3];

        temp[4] = state[5];
        temp[5] = state[6];
        temp[6] = state[7];
        temp[7] = state[4];

        temp[8] = state[10];
        temp[9] = state[11];
        temp[10] = state[8];
        temp[11] = state[9];

        temp[12] = state[15];
        temp[13] = state[12];
        temp[14] = state[13];
        temp[15] = state[14];

        System.arraycopy(temp, 0, state, 0, 16);

        return state;
    }

    private static BigInteger rotateLeft(BigInteger bi, int shiftDistance) {
        return bi.testBit(KEY_BIT) ? bi.clearBit(KEY_BIT).setBit(0) : bi.shiftLeft(shiftDistance);
    }

//    private static BigInteger rotateState(BigInteger state) {
//        for (int i = 0; i < 16; i+=4) {
//
//        }
//    }

    private void sBox() {

    }

    private void rCon() {

    }
}
