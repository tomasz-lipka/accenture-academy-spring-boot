package com.accenture.academy.leader;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderService {

    private final LeaderRepository leaderRepository;
    List<LeaderDao> getAllLeaders() {
        return leaderRepository.findAll();
    }

    void addLeader(LeaderDao leaderDao){
        leaderRepository.save(leaderDao);
    }

    void addLeader(LeaderDto leaderDto){
        leaderRepository.save(LeaderMapper.mapDtoToDao(leaderDto));
    }

    void updateLeader(long id, LeaderDto leaderDto){
        leaderRepository.save(LeaderMapper.mapDtoToDao(id, leaderDto));
    }

    public LeaderDao getLeaderById(long id) {
        return leaderRepository
                .findByID(id)
                .orElseThrow(()->new LeaderNotFoundException("Leader with id " + id + " not found"));
    }

    void deleteLeaderById(long id) {
        leaderRepository
                .findByID(id)
                .orElseThrow(() -> new LeaderNotFoundException("Leader with id " + id + " not found"));
        leaderRepository.deleteById(id);
    }

    List<LeaderDao> getLeaderByName(String name) {
        return leaderRepository.getByName(name);
    }
}
