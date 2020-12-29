package org.letokba.g2048;

/**
 * @author Wait
 * @date 2020/12/29
 */
public class GameCore {

    private static class SquareMatrix {
        private static final int SIZE = 4;
        private final int[] array;

        private SquareMatrix(int[] array){
            this.array = array;
        }

        public int get(int i, int j) {
            return array[index(i, j)];
        }

        public void set(int i, int j, int value) {
            array[index(i, j)] = value;
        }

        private int index(int i, int j) {
            int k = i * SIZE + j;
            if(k > array.length) {
                throw new ArrayIndexOutOfBoundsException("i = " + i + ", j = " + j);
            }
            return i * SIZE + j;
        }

    }

    private void transpose() {

    }

    private void hFlip() {

    }

    private void vFlip() {

    }

    private void clearZeros() {

    }

    private void mergeSame() {

    }










}
