package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
class ParishRepository {
    private final IParishRepository iParishRepository;

    List<ParishDao> findAll() {
        return iParishRepository.findAll();
    }

    void save(ParishDao parishDao) {
        iParishRepository.save(parishDao);
    }
}
