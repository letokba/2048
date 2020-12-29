package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class GameCoreTest {
    private int[] array = {
            2, 2, 2, 2,
            2, 0, 2, 2,
            0, 0, 2, 4,
            0, 0, 2, 2
    };

    private GameCore gameCore = new GameCore();

    @Before
    public void setUp() throws Exception {
        gameCore.of(array);
    }

    @After
    public void tearDown() throws Exception {
        int[] matrix = gameCore.toArray();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i * 4 + j] + "\t");
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
        gameCore.transpose();
    }

    @Test
    public void hFlip() {
        gameCore.hFlip();
    }

    @Test
    public void vFlip() {
        gameCore.vFlip();
    }

    @Test
    public void clearZeros() {
        gameCore.clearZeros();
    }

    @Test
    public void mergeSame() {
        gameCore.mergeSame();
    }


}