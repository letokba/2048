package org.letokba.g2048.api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.letokba.g2048.core.GameHandler;
import org.letokba.g2048.core.TestUtils;

import static org.junit.Assert.*;

public class GameServletTest {

    private final int[] array = {
            0, 4, 8, 4,
            4, 2, 4, 8,
            2, 4, 2, 4,
            4, 2, 4, 2
    };


    private final GameHandler handler = new GameHandler();
    private int[] result;

    @Before
    public void setUp() throws Exception {
        TestUtils.printArray(array);
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.printArray(result);
        System.out.println("gameOver: " + handler.isGameOver(array));
    }

    @Test
    public void gameOver() {
        result = handler.move(array, "left");
    }


}