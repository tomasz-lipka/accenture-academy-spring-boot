package com.accenture.academy.apiconsuming.joke;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiConsumingJokeService {

    private final HttpClient httpClient;

    @PostConstruct
    public void getJoke()  {
        try {
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(create("https://official-joke-api.appspot.com/random_joke"))
                    .build();

            HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String response = httpResponse.body().toString();

            ObjectMapper objectMapper = new ObjectMapper();
            Joke joke = objectMapper.readValue(response, Joke.class);

            System.out.println("-----------JOKE-------------");
            System.out.println("Sout raw response:");
            System.out.println(response);

            log.info("Logging raw response:");
            log.info(response);

            log.info("Logging joke object:");
            log.info(joke.toString());

        } catch (IOException | InterruptedException e) {
            log.info("(CHECK INTERNET CONNECTION) " + e );
        }
    }
}
