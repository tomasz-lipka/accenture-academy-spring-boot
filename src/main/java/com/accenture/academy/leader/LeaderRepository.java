package com.accenture.academy.leader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<LeaderDao> findByID(Long id){
        return iLeaderRepository.findById(id);
    }
}
