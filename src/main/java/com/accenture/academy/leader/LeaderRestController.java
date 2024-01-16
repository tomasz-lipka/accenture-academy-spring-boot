package com.accenture.academy.leader;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/leaders")
@RequiredArgsConstructor
class LeaderRestController {

    private final LeaderService leaderService;

    @GetMapping()
    List<LeaderDao> getAllLeaders(){
        return leaderService.getAllLeaders();
    }

    @PostMapping
    void addLeader(@RequestBody LeaderDto leaderDto){
        leaderService.addLeader(leaderDto);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity getLeaderById(@PathVariable long id){
        try{
            return ResponseEntity
                    .status(200)
                    .body(leaderService.getLeaderById(id));
        } catch (LeaderNotFoundException e){
            return ResponseEntity
                    .status(404)
                    .body(e.getMessage());
        }
    }
    
}
