package com.accenture.academy.leader;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class LeaderDataInitializer {

    private final LeaderService leaderService;

    @PostConstruct
    void initLeaderes(){
        leaderService.addLeader(
                new LeaderDao(
                "Grzegorz",
                70
        ));
        leaderService.addLeader(
                new LeaderDao(
                "Franciszek",
                77
        ));
        leaderService.addLeader(
                new LeaderDao(
                "Paweł",
                65
        ));
    }
}
