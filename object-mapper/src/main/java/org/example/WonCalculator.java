package org.example;

import org.example.component.ICalculator;

public class WonCalculator implements ICalculator {

    public int price = 1;

    @Override
    public int plus(int x, int y) {
        x *= price;
        y *= price;

        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;

        return x - y;
    }

    @Override
    public void init() {

    }
}
