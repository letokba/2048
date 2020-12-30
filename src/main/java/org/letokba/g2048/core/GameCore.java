package org.letokba.g2048.core;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Wait
 * @date 2020/12/29
 */
public class GameCore {
    private final SquareMatrix matrix;
    private final Random random = new Random();

    public GameCore() {
        matrix = new SquareMatrix(new int[16]);
    }

    public void of(int[] array) {
        this.matrix.load(array);
    }

    public int[] toArray() {
        return matrix.array;
    }

    private static class SquareMatrix {
        private static final int SIZE = 4;
        private final int[] array;

        public SquareMatrix(int[] array){
            this.array = array;
        }

        public void load(int[] array) {
            System.arraycopy(array, 0, this.array, 0, array.length);
        }

        public int get(int i, int j) {
            return array[index(i, j)];
        }

        public void set(int i, int j, int value) {
            array[index(i, j)] = value;
        }

        private int index(int i, int j) {
            int k = i * SIZE + j;
            if(k >= array.length) {
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
        public int col() {
            return SIZE;
        }

        private void replaceOneRow(int row, int[] array) {
            System.arraycopy(array, 0, this.array, row * SIZE, SIZE);
        }

        public boolean allZeros() {
            boolean allZeros = true;
            for (int i : array) {
                if(i != 0) {
                    allZeros = false;
                    break;
                }
            }
            return allZeros;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            SquareMatrix that = (SquareMatrix) o;
            return Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }

    public GameCore transpose() {
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = i + 1; j < matrix.col(); j++) {
                int k = matrix.get(i, j);
                matrix.set(i, j, matrix.get(j, i));
                matrix.set(j, i, k);
            }
        }
        return this;
    }

    public GameCore hFlip() {
        int col = matrix.col();
        for(int i = 0; i < matrix.row(); i++) {
            for(int j = 0; j < matrix.col() / 2; j++) {
                int k = matrix.get(i, j);
                matrix.set(i, j, matrix.get(i, col - j - 1));
                matrix.set(i, col - j - 1, k);
            }
        }
        return this;
    }

    public GameCore vFlip() {
        return this.transpose().hFlip().transpose();
    }

    public GameCore merge() {
        return this.clearZeros().mergeSame().clearZeros();
    }

    public GameCore clearZeros() {
        int[] cap = new int[matrix.col()];
        for(int i = 0; i < matrix.row(); i++) {
            int k = 0;
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

    public GameCore mergeSame() {
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

    public GameCore randomAdd() {
        if(matrix.allZeros()){
            return this;
        }

        int i, j;
        do {
            i = random.nextInt(matrix.row());
            j = random.nextInt(matrix.col());
        }while (matrix.isNotZero(i, j));
        int value = random.nextInt(2) * 2 + 2;
        matrix.set(i, j, value);
        return this;
    }

    public boolean hasNotChanged(int[] array) {
        return Arrays.equals(array, matrix.array);
    }
}
