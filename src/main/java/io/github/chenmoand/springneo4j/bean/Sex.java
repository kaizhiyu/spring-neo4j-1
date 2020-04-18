package io.github.chenmoand.springneo4j.bean;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum Sex {
    MALE('男'),
    FEMALE('女'),
    UNKNOWN('无');

    @Getter
    private final char sex;

    Sex(char sex) {
        this.sex = sex;
    }
}
