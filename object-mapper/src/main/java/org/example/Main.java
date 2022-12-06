package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(Main.class, args);

        ObjectMapper objectMapper = new ObjectMapper();

        Owner owner = new Owner();
        owner.setAge(9999);
        owner.setName("text");

        Car car1 = new Car();
        car1.setName("KIA");
        car1.setType("Sedan");

        Car car2 = new Car();
        car2.setName("BMW");
        car2.setType("Sedan");

        owner.setCars(Arrays.asList(car1, car2));

        System.out.println(owner);

        String json = objectMapper.writeValueAsString(owner);
        System.out.println(json);

        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        ArrayNode cars = (ArrayNode) jsonNode.get("cars");
        List<Car> _cars = objectMapper.convertValue(cars, new TypeReference<List<Car>>() {
        });

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "foo");
        objectNode.put("age", 99999);

        System.out.println(objectNode.toPrettyString());
    }
}