package com.accenture.academy.church;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/churches")
@RequiredArgsConstructor
class ChurchRestController {

    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches(){
        return churchService.getAllChurches();
    }

    @PostMapping
    void addChurch(@RequestBody ChurchDto churchDto){
        churchService.addChurch(churchDto);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity getChurchById(@PathVariable long id){
        try{
            return ResponseEntity
                    .status(200)
                    .body(churchService.getChurchById(id));
        } catch (ChurchNotFoundException e){
            return ResponseEntity
                    .status(404)
                    .body(e.getMessage());
        }
    }
}
