package org.letokba.g2048;

import java.util.Random;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class RandomUtils {

    private static final Random random = new Random();

    public static int[] randomArray() {
        int[] array = new int[16];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(3) * 2;
        }
        return array;
    }
}
