package com.accenture.academy.parish;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ParishService {

    private final ParishRepository parishRepository;
    private final ParishMapper parishMapper;

    List<ParishDao> getAllParishes() {
        return parishRepository.findAll();
    }

    void addParish(ParishDto parishDto){
        parishRepository.save(parishMapper.mapDtoToDao(parishDto));
    }
}
