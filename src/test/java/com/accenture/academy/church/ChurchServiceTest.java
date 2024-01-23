package com.accenture.academy.church;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}