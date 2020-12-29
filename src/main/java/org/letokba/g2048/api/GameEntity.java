package org.letokba.g2048.api;

import jdk.nashorn.internal.objects.annotations.Property;

import java.util.Arrays;

/**
 * @author Yong
 * @date 2020/12/29
 */
public class GameEntity {
    @Property(name = "direction")
    private String direction;
    @Property(name = "matrix")
    private int[] matrix;

    public void setArray(int[] array) {
        this.matrix = array;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int[] getMatrix() {
        return matrix;
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "direction='" + direction + '\'' +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
