package com.accenture.academy.leader;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController()
@RequestMapping("/api/leaders")
@RequiredArgsConstructor
class LeaderRestController {

    private final LeaderService leaderService;

    @GetMapping()
    List<LeaderDao> getAllLeaders(@RequestParam(required = false) Optional<String> name){
        if(name.isEmpty()) {
            return leaderService.getAllLeaders();
        } else {
            return leaderService.getLeaderByName(name.get());
        }
    }

    @PostMapping
    void addLeader(@RequestBody LeaderDto leaderDto){
        leaderService.addLeader(leaderDto);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(OK)
    LeaderDao getLeaderById(@PathVariable long id){
        return leaderService.getLeaderById(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    void updateLeader(@PathVariable long id, @RequestBody LeaderDto leaderDto){
        leaderService.updateLeader(id, leaderDto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    void deleteById(@PathVariable long id){
        leaderService.deleteLeaderById(id);
    }

    @GetMapping(path = "/search")
    @ResponseStatus(OK)
    public List<LeaderDao> geByName(@RequestParam String name) {
        return leaderService.getLeaderByName(name);
    }
}
