package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.letokba.g2048.core.GameHandler;

public class GameHandlerTest {
    private final int[] array = TestUtils.randomArray();
    private final GameHandler handler = new GameHandler();
    private int[] result;

    @Before
    public void setUp() throws Exception {
        TestUtils.printArray(array);
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.printArray(result);
    }


    @Test
    public void Right() {
        result  = handler.move(array, "Right");
    }

    @Test
    public void Left() {
        result = handler.move(array, "LEFT");
    }

    @Test
    public void Up() {
        result = handler.move(array, "UP");
    }

    @Test
    public void Down() {
        result = handler.move(array, "down");
    }


}