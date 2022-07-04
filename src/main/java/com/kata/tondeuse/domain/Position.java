package com.kata.tondeuse.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {

    private int x;
    private int y;

    private Direction direction;

    public void moveNorth(Field field) {
        if (field.canMove(x, y--)) y--;
    }

    public void moveSouth(Field field) {
        if (field.canMove(x, y++)) y++;
    }

    public void moveWest(Field field) {
        if (field.canMove(x--, y)) x--;
    }

    public void moveEast(Field field) {
        if (field.canMove(x++, y)) x++;
    }

}
