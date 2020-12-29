package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.letokba.g2048.GameCore.SquareMatrix;
public class GameCoreTest {
    private int[] array = {
            2, 2, 2, 2,
            2, 0, 2, 2,
            0, 0, 2, 4,
            0, 0, 2, 2
    };

    private GameCore gameCore = new GameCore();
    private SquareMatrix matrix;

    @Before
    public void setUp() throws Exception {
        matrix = new SquareMatrix(array);
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < matrix.row(); i++) {
            for (int j = 0; j < matrix.col(); j++) {
                System.out.print(matrix.get(i, j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void init() {

    }

    @Test
    public void transpose() {
        gameCore.transpose(matrix);
    }

    @Test
    public void hFlip() {
        gameCore.hFlip(matrix);
    }

    @Test
    public void vFlip() {
        gameCore.vFlip(matrix);
    }

    @Test
    public void clearZeros() {
        gameCore.clearZeros(matrix);
    }

    @Test
    public void mergeSame() {
        gameCore.mergeSame(matrix);
    }
}