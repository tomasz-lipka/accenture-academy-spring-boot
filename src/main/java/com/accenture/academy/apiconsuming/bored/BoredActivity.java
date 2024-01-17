package com.accenture.academy.apiconsuming.bored;

public record BoredActivity(
            String activity,
            String type,
            int participants,
            double price,
            String link,
            String key,
            double accessibility
) {
}
