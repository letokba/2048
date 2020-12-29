package org.letokba.g2048;

import java.util.Arrays;

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

        public boolean isNotZero(int i, int j) {
            return get(i, j) != 0;
        }

        public int row() {
            return SIZE;
        }
        private int col() {
            return SIZE;
        }

        private void replaceOneRow(int row, int[] array) {
            System.arraycopy(array, 0, this.array, row * SIZE, SIZE);
        }

    }

    private GameCore transpose(SquareMatrix matrix) {
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = i + 1; j < matrix.col(); j++) {
                int k = matrix.get(i, j);
                matrix.set(j, i, matrix.get(i, j));
                matrix.set(i, j, k);
            }
        }
        return this;
    }

    private GameCore hFlip(SquareMatrix matrix) {
        int col = matrix.col();
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = 0; j < matrix.col() / 2; j++) {
                int k = matrix.get(i, j);
                matrix.set(i, j, matrix.get(i, col - j));
                matrix.set(i, col - j, k);
            }
        }
        return this;
    }

    private GameCore vFlip(SquareMatrix matrix) {
        return this.transpose(matrix).hFlip(matrix);
    }



    private GameCore clearZeros(SquareMatrix matrix) {
        int[] cap = new int[matrix.col()];
        int k = 0;
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = 0; j < matrix.col(); j++) {
                if(matrix.isNotZero(i, j)){
                    cap[k++] = matrix.get(i, j);
                }
            }
            matrix.replaceOneRow(i, cap);
            Arrays.fill(cap, 0);
        }
        return this;
    }

    private GameCore mergeSame(SquareMatrix matrix) {
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = 0; j < matrix.col() - 1; j++) {
                int pre = matrix.get(i, j);
                int next = matrix.get(i, j + 1);
                if(pre == next) {
                    matrix.set(i, j, pre + next);
                    matrix.set(i, j + 1, 0);
                    j++;
                }
            }
        }
        return this;
    }










}
