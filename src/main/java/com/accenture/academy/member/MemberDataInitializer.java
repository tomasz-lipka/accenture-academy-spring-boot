package com.accenture.academy.member;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class MemberDataInitializer {

    private final MemberService memberService;

    @PostConstruct
    void initMemberes(){
        MemberDao memberDao = new MemberDao(
                "Marcin",
                20
        );
        memberService.addMember(memberDao);

        MemberDao memberDao2 = new MemberDao(
                "Grażyna",
               25
        );
        memberService.addMember(memberDao2);

        MemberDao memberDao3 = new MemberDao(
                "Jan",
                65
        );
        memberService.addMember(memberDao3);
    }
}
