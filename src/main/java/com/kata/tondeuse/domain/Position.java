package com.kata.tondeuse.domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Position {

    private int x;
    private int y;


    public void moveNorth() {
        y++;
    }

    public void moveSouth() {
        y--;
    }

    public void moveWest() {
        x--;
    }

    public void moveEast() {
        x++;
    }

    @Override
    public String toString() {
        return
                x + " " + y;
    }
}
