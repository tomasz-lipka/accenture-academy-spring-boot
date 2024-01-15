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

        MemberDao memberDao4 = new MemberDao(
                "Maciej",
                20
        );
        memberService.addMember(memberDao4);

        MemberDao memberDao5 = new MemberDao(
                "Adam",
                25
        );
        memberService.addMember(memberDao5);

        MemberDao memberDao6 = new MemberDao(
                "Łukasz",
                65
        );
        memberService.addMember(memberDao6);
    }
}
