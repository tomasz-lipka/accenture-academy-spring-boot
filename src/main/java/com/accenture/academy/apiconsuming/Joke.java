package com.accenture.academy.apiconsuming;

import lombok.Data;

public record Joke (
        long id,
        String type,
        String setup,
        String punchline
) { }
