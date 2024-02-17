package com.jobayed.orderservice.utility;

import java.util.Random;

public class Utils {
    private static final int RAND_GEN_START = 101;
    private static final int RAND_GEN_END = 2000;

    public static String orderUniqueIdGenerator() {
        final long now = System.currentTimeMillis();
        String nowStr = Long.toHexString(now);
        final String randomStr = randomGen();

        return nowStr + randomStr;
    }

    public static String randomGen() {
        Random random = new Random();
        return String.valueOf(random.nextInt(RAND_GEN_START) + RAND_GEN_END);
    }
}
