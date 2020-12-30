package org.letokba.g2048.core;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class GameHandler {
    private final GameAction gameAction;
    private final GameCore gameCore;

    public GameHandler(){
        this.gameAction = new GameAction();
        this.gameCore = new GameCore();
    }

    enum Action{
        /** */
        UP, DOWN, LEFT, RIGHT
    }

    private int[] move(int[] array, Action action) {
        gameCore.of(array);
        switch (action) {
            case UP:
                gameAction.moveUp(gameCore);
                break;
            case DOWN:
                gameAction.moveDown(gameCore);
                break;
            case LEFT:
                gameAction.moveLeft(gameCore);
                break;
            case RIGHT:
                gameAction.moveRight(gameCore);
            default:
                break;
        }
        return gameCore.randomAdd().toArray();
    }

    public int[] move(int[] array, String direction) {
        assert direction != null;
        assert array != null && array.length == 16;
        Action moveAction;
        moveAction = Action.valueOf(direction.toUpperCase());
        return move(array, moveAction);
    }

    public boolean isGameOver(int[] array) {
        return gameCore.hasNotChanged(array);
    }
}
