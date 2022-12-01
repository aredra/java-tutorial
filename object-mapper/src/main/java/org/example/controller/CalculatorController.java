package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.component.Calculator;
import org.example.dto.Req;
import org.example.dto.Resp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.plus(x, y);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        return calculator.minus(x, y);
    }

    @PostMapping("/minus")
    public Resp postMinus(@RequestBody Req req) {
        Resp result = new Resp();
        result.setResultCode("OK");
        result.setResultBody((new Resp.Body()).setResult(calculator.minus(req.getX(), req.getY())));
        return result;
    }

}
