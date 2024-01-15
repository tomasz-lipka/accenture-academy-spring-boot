package com.accenture.academy.leader;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
