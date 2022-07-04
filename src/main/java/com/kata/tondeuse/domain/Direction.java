package com.kata.tondeuse.domain;

public enum Direction implements Movable{
    N("N", "W", "E"){
        @Override
        public void move(Position position) {
            position.moveNorth();
        }
    },
    E("E", "N", "S") {
        @Override
        public void move(Position position) {
            position.moveEast();
        }
    },
    S("S", "E", "W") {
        @Override
        public void move(Position position) {
            position.moveSouth();
        }
    },
    W("W", "S", "N") {
        @Override
        public void move(Position position) {
            position.moveWest();
        }
    };

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Direction getLeft() {
        return fromValue(this.left);
    }

    public Direction getRight() {
        return fromValue(this.right);
    }

    public static Direction fromValue(String value) {
        for (Direction d : values()) {
            if (d.value.equals(value)) {
                return d;
            }
        }
        throw new IllegalArgumentException("invalid enum value");
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
