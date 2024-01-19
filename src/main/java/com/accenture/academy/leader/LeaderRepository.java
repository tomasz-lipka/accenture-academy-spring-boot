package com.accenture.academy.leader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class LeaderRepository {
    private final ILeaderRepository iLeaderRepository;

    List<LeaderDao> findAll() {
        return iLeaderRepository.findAll();
    }

    void save(LeaderDao leaderDao) {
        iLeaderRepository.save(leaderDao);
    }

    Optional<LeaderDao> findByID(Long id){
        return iLeaderRepository.findById(id);
    }

    void deleteById(long id) {
        iLeaderRepository.deleteById(id);
    }

    List<LeaderDao> getByName(String name) {
        return iLeaderRepository.findByName(name);
    }
}
