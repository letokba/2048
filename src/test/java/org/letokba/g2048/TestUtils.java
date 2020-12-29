package org.letokba.g2048;

import java.util.Random;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class TestUtils {

    private static final Random random = new Random();

    public static int[] randomArray() {
        int[] array = new int[16];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(3) * 2;
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i * 4 + j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
