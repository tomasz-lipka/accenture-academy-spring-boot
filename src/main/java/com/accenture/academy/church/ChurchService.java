package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurchService {

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

    public ChurchDao getChurchById(long id) {
        return churchRepository
                .findByID(id)
                .orElseThrow(()->new ChurchNotFoundException("Church with id " + id + " not found"));
    }

    void updateChurch(long id, ChurchDto churchDto) {
        churchRepository.save(ChurchMapper.mapDtoToDao(id, churchDto));
    }

    void deleteChurchById(long id) {
        churchRepository.deleteById(id);
    }
}
