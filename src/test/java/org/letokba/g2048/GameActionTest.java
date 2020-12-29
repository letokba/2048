package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameActionTest {

    private final int[] array = RandomUtils.randomArray();


    private GameCore gameCore = new GameCore();
    private GameAction gameAction = new GameAction();
    @Before
    public void setUp() throws Exception {
        gameCore.of(array);
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
    public void moveLeft() {
        gameAction.moveLeft(gameCore);
    }

    @Test
    public void moveRight() {
        gameAction.moveRight(gameCore);
    }

    @Test
    public void moveUp() {
        gameAction.moveUp(gameCore);
    }

    @Test
    public void moveDown() {
        gameAction.moveDown(gameCore);
    }
}