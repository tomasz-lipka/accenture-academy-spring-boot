package com.accenture.academy.apiconsuming.cat;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

@Service
@Slf4j
public class ApiConsumingCatService {

    @EventListener(ApplicationReadyEvent.class)
    public void getCatFact() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://catfact.ninja/fact"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        CatFact catFact = objectMapper.readValue(response, CatFact.class);

        System.out.println("-----------CAT-------------");

        System.out.println("Sout raw response:");
        System.out.println(response);

        log.info("Logging raw response:");
        log.info(response);

        log.info("Logging catFact object:");
        log.info(catFact.toString());
    }
}
