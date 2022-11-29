package com.example.client.service;

import com.example.client.dto.Req;
import com.example.client.dto.UserRequest;
import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@Slf4j
@Service
public class RestTemplateService {

    private String BASE_SERVER_URL = "http://localhost:8090";

    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString(BASE_SERVER_URL)
                .path("/api/server/hello")
                .queryParam("name", "test")
                .queryParam("age", 9999)
                .encode()
                .build()
                .toUri();

        log.info(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri,
                UserResponse.class);

        return result.getBody();
    }


    public UserResponse post() {

        URI uri = UriComponentsBuilder.fromUriString(BASE_SERVER_URL)
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100, "test")
                .toUri();

        log.info(uri.toString());

        UserRequest req = new UserRequest();
        req.setName("dev");
        req.setAge(999);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        log.info(response.getStatusCode().toString());
        log.info(response.getHeaders().toString());
        log.info(Objects.requireNonNull(response.getBody()).toString());

        return response.getBody();
    }

    public UserResponse exchange() {

        URI uri = UriComponentsBuilder.fromUriString(BASE_SERVER_URL)
                .path("/api/server/user/{userId}/header")
                .encode()
                .build()
                .expand(200, "test")
                .toUri();

        log.info(uri.toString());

        UserRequest req = new UserRequest();
        req.setName("dev1");
        req.setAge(9999);

        RequestEntity<UserRequest> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "bearer")
                .header("custom-header", "test")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.exchange(requestEntity, UserResponse.class);

        return response.getBody();
    }

    public Req<UserResponse> genericExchange() {

        URI uri = UriComponentsBuilder.fromUriString(BASE_SERVER_URL)
                .path("/api/server/user/{userId}/irregular")
                .encode()
                .build()
                .expand(200)
                .toUri();

        log.info(uri.toString());

        UserRequest userRequest = new UserRequest();
        userRequest.setName("dev1");
        userRequest.setAge(9999);

        Req<UserRequest> req = new Req<>();
        req.setHeader(new Req.Header());
        req.setBody(userRequest);


        RequestEntity<Req<UserRequest>> requestEntity = RequestEntity.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("x-authorization", "bearer")
                .header("custom-header", "test")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Req<UserResponse>> response
                = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<>() {
        });

        return response.getBody();
    }
}
