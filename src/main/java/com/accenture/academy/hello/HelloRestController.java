package com.accenture.academy.hello;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@Profile(value = "dev")
public class HelloRestController {

    @GetMapping("/hello")
    String getHello(HttpServletRequest servletRequest, HttpServletResponse servletResponse){
        String ipAddress = servletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null){
            ipAddress = servletRequest.getRemoteAddr();
            log.info("IP ADDRESS: " + ipAddress);
        }
        return "Hello World from Accenture";
    }
}
