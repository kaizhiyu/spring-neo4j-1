package io.github.chenmoand.springneo4j;

import io.github.chenmoand.springneo4j.bean.Sex;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SimpleClassTest {
    @Test
    public void onEnumSexMethod() {
        final Sex sex = Sex.valueOf("FEMALE");
        log.info(sex.toString());
    }
}
