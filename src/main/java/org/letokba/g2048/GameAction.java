package org.letokba.g2048;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class GameAction {


    public void moveLeft(GameCore gameCore) {
        gameCore.clearZeros()
                .mergeSame()
                .clearZeros();
    }

    public void moveRight(GameCore gameCore) {
        gameCore.hFlip()
                .clearZeros()
                .mergeSame()
                .clearZeros()
                .hFlip();
    }

    public void moveUp(GameCore gameCore) {
        gameCore.transpose()
                .clearZeros()
                .mergeSame()
                .clearZeros()
                .transpose();
    }

    public void moveDown(GameCore gameCore) {
        gameCore.vFlip()
                .transpose()
                .clearZeros()
                .mergeSame()
                .clearZeros()
                .transpose()
                .vFlip();
    }


}
