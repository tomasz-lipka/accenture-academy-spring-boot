package com.accenture.academy.apiconsuming.joke;

public record Joke (
        long id,
        String type,
        String setup,
        String punchline
) { }
