package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchService;
import com.accenture.academy.leader.LeaderDao;
import com.accenture.academy.leader.LeaderService;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
class ParishMapper {

    private final LeaderService leaderService;
    private final ChurchService churchService;
    private final MemberService memberService;

    ParishDao mapDtoToDao(ParishDto parishDto) {
        LeaderDao leaderDao = leaderService.getLeaderById(parishDto.getLeaderId());
        ChurchDao churchDao = churchService.getChurchById(parishDto.getChurchId());

        Set<Long> membersIds = parishDto.getMembersIds();
        Set<MemberDao> members = new HashSet<>();
        for (Long memberId : membersIds){
            MemberDao memberDao = memberService.getMemberById(memberId);
            members.add(memberDao);
        }

        ParishDao parishDao = new ParishDao();
        parishDao.setLeaderDao(leaderDao);
        parishDao.setChurchDao(churchDao);
        parishDao.setMembers(members);
        return parishDao;
    }
}
