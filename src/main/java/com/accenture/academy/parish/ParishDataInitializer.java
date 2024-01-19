package com.accenture.academy.parish;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ParishDataInitializer {

    private final ParishService parishService;

    @PostConstruct
    void initParishes(){
        parishService.addParish(
                new ParishDto(
                        1L,
                        1L
                ));
    }
}
