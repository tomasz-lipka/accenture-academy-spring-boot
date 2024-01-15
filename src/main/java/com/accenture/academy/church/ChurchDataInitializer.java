package com.accenture.academy.church;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ChurchDataInitializer {

    private final ChurchService churchService;

    @PostConstruct
    void initChurches(){
        churchService.addChurch(
                new ChurchDao(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        ));
        churchService.addChurch(
                new ChurchDao(
                "Kościół sw. Krzyża",
                "Łódź",
                130,
                1000,
                20000.0
        ));
        churchService.addChurch(
                new ChurchDao(
                "Kościół sw. Krzyża",
                "Kraków",
                130,
                1000,
                20000.0
        ));
    }
}
