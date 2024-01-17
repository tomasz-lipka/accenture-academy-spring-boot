package com.accenture.academy.apiconsuming;

public record Joke (
        long id,
        String type,
        String setup,
        String punchline
) { }
