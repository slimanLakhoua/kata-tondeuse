package com.kata.tondeuse.domain;

import static com.kata.tondeuse.utils.Constants.MOVE_FORWARD;
import static com.kata.tondeuse.utils.Constants.RIGHT;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Mower {

    private Field field;

    private Position position;

    private String instructions;

    public void runMower() {
        if (!StringUtils.hasText(instructions)) {
            throw new IllegalArgumentException("instructions can not be empty");
        }

        instructions.chars().forEach(instruction -> {
            if (MOVE_FORWARD == instruction) {
                this.move();
            } else {
                this.changeDirection(instruction);
            }
        });
    }

    private void move()  {
        try {
        Class<?> c = Class.forName(Position.class.getName());

            Method method = c.getDeclaredMethod(this.position.getDirection().getMethodName());
            method.invoke(this.position);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeDirection(char instruction) {
        if (instruction == RIGHT) {
            this.position.setDirection(this.position.getDirection().getRight());
        } else {
            this.position.setDirection(this.position.getDirection().getLeft());
        }
    }


}
