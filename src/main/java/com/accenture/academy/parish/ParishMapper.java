package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchService;
import com.accenture.academy.leader.LeaderDao;
import com.accenture.academy.leader.LeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class ParishMapper {

    private final LeaderService leaderService;
    private final ChurchService churchService;

    ParishDao mapDtoToDao(ParishDto parishDto) {
        LeaderDao leaderDao = leaderService.getLeaderById(parishDto.getLeaderId());
        ChurchDao churchDao = churchService.getChurchById(parishDto.getChurchId());

        ParishDao parishDao = new ParishDao();
        parishDao.setLeaderDao(leaderDao);
        parishDao.setChurchDao(churchDao);

        return parishDao;
    }
}
