package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ChurchService {

    private final ChurchRepository churchRepository;

    List<ChurchDao> getAllChurches() {
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }

    void addChurch(ChurchDto churchDto){
        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto));
    }

    ChurchDao getChurchById(long id) {
        return churchRepository
                .findByID(id)
                .orElseThrow(()->new ChurchNotFoundException("Church with id " + id + " not found"));
    }

    public void updateChurch(long id, ChurchDto churchDto) {
        churchRepository.save(ChurchMapper.mapDtoToDao(id, churchDto));
    }
}
