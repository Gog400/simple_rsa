package uk.RsaEncryption;

import java.util.Random;

public class RsaBase {

    public static final int MIN_NUMBER = 2; // 1024
    public static final int MAX_NUMBER = 29; // 4096
    public static final Random rand = new Random();

    protected int findProduct(int p, int q) {
        return p * q;
    }

    protected int findTotient(int p, int q) {
        return (p - 1) * (q - 1);
    }

    protected static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
