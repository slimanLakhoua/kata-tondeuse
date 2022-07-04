package com.kata.tondeuse.domain;

public enum Direction {
    N('N', 'W', 'E',"moveNorth"),
    E('E', 'N', 'S',"moveEast"),
    S('S', 'E', 'W',"moveSouth"),
    W('W', 'S', 'N',"moveWest");

    private final char value;
    private final char left;
    private final char right;
    private final String methodName;

    Direction(char value, char left, char right, String methodName) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.methodName = methodName;
    }

    public Direction getLeft() {
        return fromValue(this.left);
    }

    public Direction getRight() {
        return fromValue(this.right);
    }

    public String getMethodName() {
        return methodName;
    }

    public static Direction fromValue(char value) {
        for (Direction d : values()) {
            if (d.value == value) {
                return d;
            }
        }
        throw new IllegalArgumentException("invalid enum value");
    }
}
