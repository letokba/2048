package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.letokba.g2048.core.GameCore;

public class GameCoreTest {
    private final int[] array = TestUtils.randomArray();

    private final GameCore gameCore = new GameCore();

    @Before
    public void setUp() throws Exception {
        gameCore.of(array);
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.printArray(array);
        int[] result = gameCore.toArray();
        TestUtils.printArray(result);
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

    @Test
    public void randomAdd() {
        gameCore.randomAdd();
    }

}