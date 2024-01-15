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
        LeaderDao leaderDao = new LeaderDao(
                "Grzegorz",
                70
        );
        leaderService.addLeader(leaderDao);

        LeaderDao leaderDao2 = new LeaderDao(
                "Franciszek",
               77
        );
        leaderService.addLeader(leaderDao2);

        LeaderDao leaderDao3 = new LeaderDao(
                "Paweł",
                65
        );
        leaderService.addLeader(leaderDao3);
    }
}
