package com.accenture.academy.apiconsuming.geoapify.reverse;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "accenture.academy.geoapify")
@Data
@Component
public class ReverseConfig {
    private String apikey2;
}
