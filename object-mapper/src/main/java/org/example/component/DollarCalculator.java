package org.example.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

    private int price = 1;
    private final MarketApi marketApi;

    public void init() {
        this.price = this.marketApi.connect();
    }

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
}
