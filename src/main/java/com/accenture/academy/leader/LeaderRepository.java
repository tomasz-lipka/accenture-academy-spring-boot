package com.accenture.academy.leader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class LeaderRepository {
    private final ILeaderRepository iLeaderRepository;

    public List<LeaderDao> findAll() {
        return iLeaderRepository.findAll();
    }

    public void save(LeaderDao leaderDao) {
        iLeaderRepository.save(leaderDao);
    }
}
