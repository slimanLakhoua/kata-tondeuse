package com.kata.tondeuse.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.kata.tondeuse.utils.Constants.SEPARATOR;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Field {

    private int lastX;
    private int lastY;

    public Field(String coordinatesAsString) {
        if (coordinatesAsString.length() != 3) {
            throw new IllegalArgumentException("invalid coordinates");
        }

        lastX = Integer.parseInt(coordinatesAsString.substring(0, 1));
        lastY = Integer.parseInt(coordinatesAsString.substring(coordinatesAsString.lastIndexOf(SEPARATOR) + 1));
    }

    public boolean canMoveOnXAxis(Integer x) {
        return x >= 0 && x <= lastX;
    }

    public boolean canMoveOnYAxis(Integer y) {
        return y >= 0 && y <= lastY;
    }
}
