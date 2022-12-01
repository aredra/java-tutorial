package org.example.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;


@SpringBootTest
class DollarCalculatorTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private Calculator calculator;

    @Test
    public void dollarCalculatorTest() {

        Mockito.when(marketApi.connect()).thenReturn(1200);

        int sum = calculator.plus(10, 10);
        int diff = calculator.minus(20, 20);

        Assertions.assertEquals(24000, sum);
        Assertions.assertEquals(0, diff);

    }
}