package com.accenture.academy.leader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class LeaderService {

    private final LeaderRepository leaderRepository;
    List<LeaderDao> getAllLeaders() {
        return leaderRepository.findAll();
    }

    void addLeader(LeaderDao leaderDao){
        leaderRepository.save(leaderDao);
    }
}
