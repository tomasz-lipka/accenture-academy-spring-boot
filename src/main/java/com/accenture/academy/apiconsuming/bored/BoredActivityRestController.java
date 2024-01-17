package com.accenture.academy.apiconsuming.bored;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;


@Slf4j
@RestController
@RequiredArgsConstructor
public class BoredActivityRestController {

    private final BoredActivityService boredActivityService;

    @GetMapping("bored-activity")
    public BoredActivity getActivity() throws IOException, InterruptedException {
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

        System.out.println("-----------ACTIVITY-------------");

        System.out.println("Sout raw response:");
        System.out.println(response);

        log.info("Logging raw response:");
        log.info(response);

        log.info("Logging activity object:");
        log.info(boredActivity.toString());

        return boredActivity;
    }
}
