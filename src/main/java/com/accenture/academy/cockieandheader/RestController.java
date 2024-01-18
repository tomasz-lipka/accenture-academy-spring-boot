package com.accenture.academy.cockieandheader;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.URI.create;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final HttpClient httpClient;

    @GetMapping("/ip-address")
    String getIPAddress(HttpServletRequest servletRequest){
        String ipAddress = servletRequest.getHeader("X-FORWARDED-FOR");
        StringBuilder stringBuilder = new StringBuilder("IP address=");
        String response = "";
        if (ipAddress == null){
            response = servletRequest.getRemoteAddr();
        }
        return stringBuilder.append(response).toString();
    }

    @GetMapping("/key-from-header")
    String getKeyFromHeader(HttpServletRequest servletRequest){
        String custom = servletRequest.getHeader("my-custom-key");
        return "my-custom-key=" + custom;
    }

    @GetMapping("/cookie-to-response")
    void addCookieToResponse(HttpServletResponse servletResponse){
        Cookie cookie = new Cookie("my-custom-cookie", "ciasteczko");
        servletResponse.addCookie(cookie);
    }

    @GetMapping("/key-to-response")
    void addKeyToResponse(HttpServletResponse servletResponse){
        servletResponse.addHeader("my-custom-key", "to-header");
    }

    @GetMapping("/header-to-ext-api")
    String sendHeaderToExternalApi() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(create("https://official-joke-api.appspot.com/random_joke"))
                .header("custom-header", "custom-header-value")
                .build();
        httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return "Header: " + httpRequest.headers().toString();
    }
}
