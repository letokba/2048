package org.letokba.g2048;


/**
 * @author Yong
 * @date 2020/12/29
 */
public class GameAction {

    public void moveLeft(GameCore gameCore) {
        gameCore.merge();
    }

    public void moveRight(GameCore gameCore) {
        gameCore.hFlip()
                .merge()
                .hFlip();
    }

    public void moveUp(GameCore gameCore) {
        gameCore.transpose()
                .merge()
                .transpose();
    }

    public void moveDown(GameCore gameCore) {
        gameCore.transpose()
                .hFlip()
                .merge()
                .hFlip()
                .transpose();
    }


}
