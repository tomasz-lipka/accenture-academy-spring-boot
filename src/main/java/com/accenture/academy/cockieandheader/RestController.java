package com.accenture.academy.cockieandheader;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/ip-address")
    String getIPAddress(HttpServletRequest servletRequest){
        String ipAddress = servletRequest.getHeader("xxx");
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
}
