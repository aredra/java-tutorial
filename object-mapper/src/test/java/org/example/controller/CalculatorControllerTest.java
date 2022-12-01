package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.component.Calculator;
import org.example.component.DollarCalculator;
import org.example.component.MarketApi;
import org.example.dto.Req;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CalculatorController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
class CalculatorControllerTest {

    @MockBean
    private MarketApi marketApi;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        Mockito.when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void plusTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8090/calculator/sum")
                        .queryParam("x", "20")
                        .queryParam("y", "10")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("90000"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postMinusTest() throws Exception {

        Req req = new Req(10, 10);
        String content = (new ObjectMapper()).writeValueAsString(req);

        mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/calculator/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultBody.result").value(0))
                .andDo(MockMvcResultHandlers.print());
    }
}