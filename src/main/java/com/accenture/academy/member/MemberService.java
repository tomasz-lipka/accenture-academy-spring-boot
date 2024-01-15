package com.accenture.academy.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class MemberService {

    private final MemberRepository memberRepository;
    List<MemberDao> getAllMembers() {
        return memberRepository.findAll();
    }

    void addMember(MemberDao memberDao){
        memberRepository.save(memberDao);
    }
}
