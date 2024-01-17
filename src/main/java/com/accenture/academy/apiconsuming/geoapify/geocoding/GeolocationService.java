package com.accenture.academy.apiconsuming.geoapify.geocoding;

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
public class GeolocationService {

    private final GeolocationConfig geolocationConfig;

    @PostConstruct
    void getGeolocation() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest
                    .newBuilder()
                    .GET()
                    .uri(create("https://api.geoapify.com/v1/geocode/search?text=38%20Upper%20Montagu%20Street%2C%20Westminster%20W1H%201LJ%2C%20United%20Kingdom&apiKey=" + geolocationConfig.getApikey()))
                    .build();
            HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String response = httpResponse.body().toString();

            System.out.println("----------GEOLOCATION---------");
            System.out.println(response);
        } catch (IOException | InterruptedException e) {
            log.info("(CHECK INTERNET CONNECTION) " + e);
        }
    }
}