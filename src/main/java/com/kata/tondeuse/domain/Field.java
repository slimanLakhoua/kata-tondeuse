package com.kata.tondeuse.domain;

import static com.kata.tondeuse.utils.Constants.SEPARATOR;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Field {

    private int lastX;
    private int lastY;

    public Field(String coordinatesAsString) {
        if (coordinatesAsString.length() != 3) {
            throw new IllegalArgumentException("");
        }

        lastX = Integer.parseInt(coordinatesAsString.substring(0,1));
        lastY = Integer.parseInt(coordinatesAsString.substring(coordinatesAsString.lastIndexOf(SEPARATOR)));
    }

    public boolean canMove(Integer x, Integer y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("coordinates can not be negative");
        }
        return x <= lastX && y <= lastY;
    }
}
