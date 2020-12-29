package org.letokba.g2048;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.letokba.g2048.core.GameAction;
import org.letokba.g2048.core.GameCore;


public class GameActionTest {

    private final int[] array = TestUtils.randomArray();


    private final GameCore gameCore = new GameCore();
    private final GameAction gameAction = new GameAction();

    @Before
    public void setUp() {
        gameCore.of(array);
    }

    @After
    public void tearDown() {
        TestUtils.printArray(array);
        TestUtils.printArray(gameCore.toArray());
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