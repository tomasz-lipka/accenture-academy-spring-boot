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
        memberService.addMember(
                new MemberDao(
                "Marcin",
                20
        ));
        memberService.addMember(
                new MemberDao(
                "Grażyna",
                25
        ));
        memberService.addMember(
                new MemberDao(
                "Jan",
                65
        ));
        memberService.addMember(
                new MemberDao(
                "Maciej",
                20
        ));
        memberService.addMember(
                new MemberDao(
                "Adam",
                25
        ));
        memberService.addMember(
                new MemberDao(
                "Łukasz",
                65
        ));
    }
}
