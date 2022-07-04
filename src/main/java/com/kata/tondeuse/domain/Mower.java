package com.kata.tondeuse.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import static com.kata.tondeuse.utils.Constants.MOVE_FORWARD;
import static com.kata.tondeuse.utils.Constants.RIGHT;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Mower {

    private Field field;
    private Direction direction;
    private Position position;
    private String instructions;

    public String run() {
        if (!StringUtils.hasText(instructions)) {
            throw new IllegalArgumentException("instructions can not be empty");
        }

        instructions.chars().mapToObj(Character::toString).forEach(instruction -> {
            if (MOVE_FORWARD.equals(instruction)) {
                this.moveMower();
            } else {
                this.changeDirection(instruction);
            }
        });

        return this.toString();
    }

    private void moveMower() {
        this.direction.move(this.position, this.field);
    }

    private void changeDirection(String instruction) {
        if (RIGHT.equals(instruction)) {
            this.direction = this.direction.getRight();
        } else {
            this.direction = this.direction.getLeft();
        }
    }

    @Override
    public String toString() {
        return position + " " + direction;
    }
}
