package org.example.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator calculator;

    public int plus(int x, int y) {
        this.calculator.init();
        return this.calculator.plus(x, y);
    }

    public int minus(int x, int y) {
        this.calculator.init();
        return  this.calculator.minus(x, y);
    }
}
