package com.accenture.academy.church;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/churches")
public class ChurchRestController {

    @GetMapping()
    ChurchDto getAnyChurch(){
        ChurchDto churchDto = new ChurchDto(
                "Kościół sw. Krzyża",
                "Warszawa",
                150,
                1000,
                20000.0
        );
        return churchDto;
    }
}
