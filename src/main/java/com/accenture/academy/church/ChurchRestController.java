package com.accenture.academy.church;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

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
    void addChurch(@RequestBody @Valid ChurchDto churchDto){
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

    @PutMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    void updateChurch(@PathVariable long id, @RequestBody ChurchDto churchDto){
        churchService.updateChurch(id, churchDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable long id){
        churchService.deleteChurchById(id);
    }
}
