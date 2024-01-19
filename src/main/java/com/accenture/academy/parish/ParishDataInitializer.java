package com.accenture.academy.parish;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
class ParishDataInitializer {

    private final ParishService parishService;

    @PostConstruct
    void initParishes(){
        parishService.addParish(
                new ParishDto(
                        1L,
                        1L,
                        new HashSet<>(Arrays.asList(1L, 2L))
                ));
    }
}
