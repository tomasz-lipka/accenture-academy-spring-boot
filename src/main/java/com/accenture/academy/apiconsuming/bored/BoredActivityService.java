package com.accenture.academy.apiconsuming.bored;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

@Service
@Slf4j
class BoredActivityService {

    BoredActivity consumeApi() throws IOException, InterruptedException{
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://www.boredapi.com/api/activity"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        BoredActivity boredActivity = objectMapper.readValue(response, BoredActivity.class);

        return boredActivity;
    }
}
