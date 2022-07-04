package com.kata.tondeuse.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {

    private int x;
    private int y;


    public void moveNorth(Field field) {
        if (field.canMoveOnYAxis(y + 1)) y++;
    }

    public void moveSouth(Field field) {
        if (field.canMoveOnYAxis(y - 1)) y--;
    }

    public void moveWest(Field field) {
        if (field.canMoveOnXAxis(x - 1)) x--;
    }

    public void moveEast(Field field) {
        if (field.canMoveOnXAxis(x + 1)) x++;
    }

    @Override
    public String toString() {
        return
                x + " " + y;
    }
}
