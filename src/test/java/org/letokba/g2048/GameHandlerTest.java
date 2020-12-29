package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameHandlerTest {
    private final int[] array = RandomUtils.randomArray();
    private final GameHandler handler = new GameHandler();
    private int[] result;

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i * 4 + j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    @After
    public void tearDown() throws Exception {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(result[i * 4 + j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
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