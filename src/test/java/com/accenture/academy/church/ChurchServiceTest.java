package com.accenture.academy.church;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ChurchServiceTest {

    @Mock
    ChurchRepository churchRepository = Mockito.mock(ChurchRepository.class);

    @InjectMocks
    ChurchService churchService;

    @Test
    void testGetAllChurches(){
        ChurchDao churchDao = new ChurchDao(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        );
        Mockito.when(churchRepository.findAll()).thenReturn(List.of(churchDao));
        assertEquals(List.of(churchDao), churchService.getAllChurches());
    }

    @Test
    void testAddChurch(){
        ChurchDao churchDao = new ChurchDao(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        );
        churchService.addChurch(churchDao);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);
    }

    @Test
    void testGetChurchById(){
        ChurchDao churchDao = new ChurchDao(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        );
        Mockito.when(churchRepository.findByID(1L)).thenReturn(Optional.of(churchDao));
        assertEquals(churchDao, churchService.getChurchById(1L));
    }

    @Test
    void testGetChurchByIdException(){
        Mockito.when(churchRepository.findByID(any())).thenReturn(Optional.empty());
        assertThrows(ChurchNotFoundException.class, () -> churchService.getChurchById(99L));
    }

    @Test
    void testUpdateChurch() {
        ChurchDto churchDto = new ChurchDto(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        );
        ChurchDao churchDao = new ChurchDao(
                "Kościół sw. Krzyża",
                "Warszawa",
                130,
                1000,
                20000.0
        );
        churchDao.setId(1L);
        churchService.updateChurch(1L, churchDto);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);
    }

    @Test
    void testDeleteChurchById(){
        churchService.deleteChurchById(1L);
        Mockito.verify(churchRepository, Mockito.times(1)).deleteById(1L);
    }
}