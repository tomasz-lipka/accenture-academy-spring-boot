package com.accenture.academy.apiconsuming.geoapify.reverse;

import com.accenture.academy.apiconsuming.geoapify.reverse.model.Root;
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
public class ReverseService {

    private final ReverseConfig reverseConfig;

    @PostConstruct
    void getReverseGeolocation() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(create("https://api.geoapify.com/v1/geocode/reverse?lat=51.21709661403662&lon=6.7782883744862374&apiKey=" + reverseConfig.getApikey2()))
                    .build();
            HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String response = httpResponse.body().toString();

            System.out.println("----------REVERSE---------");
            System.out.println(response);

            ObjectMapper objectMapper = new ObjectMapper();
            Root root = objectMapper.readValue(response, Root.class);

            System.out.println("ROOT:");
            System.out.println(root.toString());

        } catch (IOException | InterruptedException e) {
            log.info("(CHECK INTERNET CONNECTION) " + e);
        }
    }
}
