package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class ChurchService {

    private final ChurchRepository churchRepository;
    private ChurchMapper churchMapper = new ChurchMapper();
    List<ChurchDao> getAllChurches() {
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }

    void addChurch(ChurchDto churchDto){
        churchRepository.save(churchMapper.mapDtoToDao(churchDto));
    }
}
