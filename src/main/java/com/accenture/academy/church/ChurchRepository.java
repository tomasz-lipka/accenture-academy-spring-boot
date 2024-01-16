package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
class ChurchRepository {
    private final IChurchRepository iChurchRepository;

    public List<ChurchDao> findAll() {
        return iChurchRepository.findAll();
    }

    public void save(ChurchDao churchDao) {
        iChurchRepository.save(churchDao);
    }

    public Optional<ChurchDao> findByID(Long id){
        return iChurchRepository.findById(id);
    }
}
